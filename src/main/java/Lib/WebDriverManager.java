package Lib;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class WebDriverManager {
	private static HashMap<Long, WebDriver> map = new HashMap<Long, WebDriver>();
	private static final Logger LOG = LoggerFactory
			.getLogger(WebDriverManager.class);
	private static HashMap<Long, WebDriverWait> waitMap = new HashMap<Long, WebDriverWait>();

	/**
	 * Gets the driver instance.
	 * 
	 * @return the driver instance
	 */
	public static WebDriver getDriverInstance() {
		return map.get(Thread.currentThread().getId());
	}

	/**
	 * Gets the wait.
	 * 
	 * @return the wait
	 */
	public static WebDriverWait getWait() {
		return waitMap.get(Thread.currentThread().getId());
	}

	/**
	 * Start driver.
	 * 
	 * @param type
	 *            the type
	 * @param portalUrl
	 *            the portal url
	 * @param timeout
	 *            the timeout
	 * @return the web driver
	 * @throws IOException
	 */
	public static WebDriver startDriver(String type, String portalUrl,
			int timeout) throws IOException {
		System.out.println("Thread started: "
				+ Thread.currentThread().toString());
		LOG.info("Type : " + type);
		WebDriver d;
		if (type.equalsIgnoreCase("chrome")) {
			d = new ChromeDriver();
			map.put(Thread.currentThread().getId(), d);
		} else if (type.equalsIgnoreCase("firefox")) {
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.manager.showWhenStarting",
					false);
			String workingDir = System.getProperty("user.dir");
			profile.setPreference("pdfjs.disabled", true);
			profile.setPreference("pdfjs.disabled", true);
			d = new FirefoxDriver(profile);
			map.put(Thread.currentThread().getId(), d);
		} else if (type.equalsIgnoreCase("ie")) {
			String BASE_PATH = System.getProperty("user.dir") + "\\";
			BASE_PATH = BASE_PATH
					+ "src\\main\\java\\com\\bdd\\util\\IEDriverServer32.exe";
			System.setProperty("webdriver.ie.driver", BASE_PATH);

			DesiredCapabilities ieCapabilities = DesiredCapabilities
					.internetExplorer();
			ieCapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			d = new InternetExplorerDriver(ieCapabilities);
			map.put(Thread.currentThread().getId(), d);
		} else {
			throw new IllegalArgumentException("Browser type not supported: "
					+ type);
		}

		d.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		waitMap.put(Thread.currentThread().getId(), new WebDriverWait(d, 60));
		d.get(portalUrl);
		return d;
	}

	/**
	 * Stop driver.
	 */
	public static void stopDriver() {
		WebDriver webDriver = map.get(Thread.currentThread().getId());
		if (webDriver != null) {
			System.out.println("Thread stopped: "
					+ Thread.currentThread().toString());
			webDriver.quit();
		}
	}
	
}
