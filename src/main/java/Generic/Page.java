package Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Lib.PropertiesManager;
import Lib.WebDriverManager;

import cucumber.api.Scenario;

public abstract class Page {

	protected String _url = null;
	protected static WebDriver _driver;
	protected static WebDriverWait _wait;
	protected static GenericPage _generic;
	protected static Scenario _scenario;
	protected boolean _screenShotEnabled;
	protected PropertiesManager _propertiesManager;

	private static final Logger LOG = LoggerFactory.getLogger(Page.class);
	public Page() throws Throwable {
		
	}

	protected void setWebDriver() {
		Page._driver = WebDriverManager.getDriverInstance();
		Page._wait = WebDriverManager.getWait();
		Page._generic = new GenericPage(Page._driver, Page._wait);
	}

	public abstract boolean isPageRenderedProperly();
}
