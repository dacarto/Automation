package Test_Page;

import Generic.Page;
import Generic.Parameters;
import Test_Page.EbayPage;
import Util.TestConfigUtil;


public class EbayPage extends Page {
	
	public EbayPage() throws Throwable {
		super();
		this._propertiesManager = TestConfigUtil
				.getProjectProperties(Parameters.EbayXpathPropertiesFile);
	}

	@Override
	public boolean isPageRenderedProperly() {
		this.setWebDriver();
		boolean pageLoaded = Page._generic.isElementDisplayed(this._propertiesManager.getValue(Parameters.EbayXpathTextEntry)); 
		return pageLoaded;
	}

	public EbayPage setText(String value) {
		Page._generic.waitAndSendKeys(this._propertiesManager
				.getValue(Parameters.EbayXpathTextEntry), value);
		return this;
	}
	
	public void clickButton() {
		Page._generic.waitAndClick(this._propertiesManager
				.getValue(Parameters.EbayXpathSearchEntry));
	}
	
	public void clickAllView() {
		Page._generic.waitAndClick(this._propertiesManager
				.getValue(Parameters.EbayXpathBrandButtonEntry));
	}
	
	public EbayPage setTextBrand(String value) {
		Page._generic.waitAndSendKeys(this._propertiesManager
				.getValue(Parameters.EbayXpathTextBrandEntry), value);
		return this;
	}
	
	public void clickCheckButton1(){
		Page._generic.waitAndClick(this._propertiesManager
		       .getValue(Parameters.EbayXpathBrandEntry));
	}
	
	public void clickCheckPu(){
		Page._generic.waitAndClick(this._propertiesManager
		       .getValue(Parameters.EbayXpathBrandPumaEntry));
	}
	
	
	public void clickApply() {
		Page._generic.waitAndClick(this._propertiesManager
				.getValue(Parameters.EbayXpathAplicarButtonEntry));
	}
	
	public void clickCheckButton2(){
		Page._generic.waitAndClick(this._propertiesManager
		       .getValue(Parameters.EbayXpathSyzeEntry));
	}
	
	public boolean getResults() {
		int iCount = Page._generic
				.returnNumberOfFoundElements(this._propertiesManager
						.getValue(Parameters.EbayXpathResultsEntry));
		System.out.println("Cantidad de zapatillas:  "+ iCount);
		if (iCount > 0)
			return true;
		return false;
	}
	
	public void clickOrder(){
		Page._generic.waitAndClick(this._propertiesManager
		       .getValue(Parameters.EbayXpathOrderEntry));
	}
	
	public EbayPage setTextPrice(String value1, String value2) {
		Page._generic.waitAndSendKeys(this._propertiesManager
				.getValue(Parameters.EbayXpathPriceMinEntry), value1);
		Page._generic.waitAndSendKeys(this._propertiesManager
				.getValue(Parameters.EbayXpathPriceMaxEntry), value2);
		return this;
	}
	
}
