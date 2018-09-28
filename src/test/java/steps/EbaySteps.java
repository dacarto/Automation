package steps;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;

import Domain.EbayDomain;
import Lib.WebDriverManager;
import Generic.Parameters;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;


public class EbaySteps {
	
	@Lazy
	private WebDriverManager driverManager;

	private EbayDomain ebayDomain = new EbayDomain();

	public WebDriver getDriver() {
		return driverManager.getDriverInstance();
	}
	
	@After
	public void ending(Scenario scenario) throws Exception{
		driverManager.stopDriver();
	}

	@Given("^Navigate to Ebay Web Site$")
	public void navigate_to_Ebay_Web_Site() throws Throwable {
		driverManager.startDriver(Parameters.FirefoxDriver, Parameters.Url, Parameters.TimeOutDriver);
		assertTrue(this.ebayDomain.IsPageValid());
	}
	
	@When("^I enter(.*)$")
	public void i_enter(String value) throws Throwable {
		this.ebayDomain.setText(value);
	}
	
	@Then("^I click the search$")
	public void i_click_the_search() throws Throwable {
		this.ebayDomain.clickOnSubmit();
	}
	
	@Then("^I view all brand$")
	public void i_view_all_brand() throws Throwable {
		this.ebayDomain.clickAllView();
	}
	
	@When("^I write brand(.*)$")
	public void i_write_brand(String value) throws Throwable {
		this.ebayDomain.setTextBrand(value);
	}
	
	@And("^I select the brand Puma$")
	public void i_selec_the_brand_puma() throws Throwable{
		this.ebayDomain.clickCheckPu();
	}
	
	@Then("^I click apply brand$")
	public void i_click_view_all_brand() throws Throwable {
		this.ebayDomain.clickApply();
	}
	
	@And("^I select the size 10$")
	public void i_select_the_size_10() throws Throwable{
		this.ebayDomain.clickCheckButton2();
	}
	
	@Then("^Print Results of the search$")
	public void print_Results_of_the_search() throws Throwable {
	    this.ebayDomain.resultsAreDisplayed();
	}
	
	@When("^I input price (.*) to (.*) asc$")
	public void i_enter_price_to_asc(String value1,String value2) throws Throwable {
		this.ebayDomain.setTextPrice(value1,value2);
	}
	
	@And ("^I click order for price$")
	public void i_click_order_for_price() throws Throwable {
	    this.ebayDomain.clickOrder();
	}
	
}