package Generic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericPage {

	protected WebDriver _driver;
	protected WebDriverWait _wait;
	
	public GenericPage(WebDriver driver, WebDriverWait wait){
		this._driver = driver;
		this._wait = wait;
	}
	
	public void waitAndClick(String xpath)
	{
		this._wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		this._driver.findElement(By.xpath(xpath)).click();
	}
	
	public void waitAndSelect(String xpath)
	{
		this._wait.until(ExpectedConditions.elementToBeSelected(By.xpath(xpath)));
		this._driver.findElement(By.xpath(xpath)).isSelected();
	}
	
	public void waitAndSendKeys(By byxpath, String expectedKeys) {
		this._wait.until(ExpectedConditions.visibilityOfElementLocated(byxpath));
		this._driver.findElement(byxpath).clear();
		this._driver.findElement(byxpath).sendKeys(expectedKeys);
	}

	public void waitAndSendKeys(String xpath, String expectedKeys) {
		waitAndSendKeys(By.xpath(xpath),expectedKeys);
	}
		

	public String waitAndGetAttribute(By byxpath, String attribute) {
		String text = "";
		this._wait.until(ExpectedConditions.presenceOfElementLocated(byxpath));
		text = this._driver.findElement(byxpath).getAttribute(attribute);
		return text;
	}

	public String waitAndGetAttribute(String xpath, String attribute) {
		return waitAndGetAttribute(By.xpath(xpath), attribute);
	}
	
	public boolean waitAndReturnIfTitleContains(String titleText){
		this._wait.until(ExpectedConditions.titleContains(titleText));
		return this._driver.getTitle().contains(titleText); 
	}
	
	public int returnNumberOfFoundElements(String xpath){
		int iCount = 0;
		this._wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		iCount = this._driver.findElements(By.xpath(xpath)).size();
		return iCount;
	}
	
	public boolean isElementDisplayed(String xpath) {
		boolean found = false;
		try {
			this._wait.until(ExpectedConditions.visibilityOf(this._driver.findElement(By.xpath(xpath))));
			found = this._driver.findElement(By.xpath(xpath)).isDisplayed(); 
		} catch (Exception e) {
		}
		return found;
	}

	public boolean relatedItemsAreDisplayed(String xpath) {
		this._wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
		return true;
	}
}
