package Domain;

import Test_Page.EbayPage;

public class EbayDomain {

	private EbayPage ebayPage;
	
	public EbayDomain() {
	}

	public boolean IsPageValid() throws Throwable  {
		this.ebayPage = new EbayPage();
		return this.ebayPage.isPageRenderedProperly();
	}
	
	public void setText(String value) {
		this.ebayPage.setText(value);
	}
	
	public void clickOnSubmit() {
		this.ebayPage.clickButton();
	}
	
	public void clickAllView() {
		this.ebayPage.clickAllView();
	}
	
	public void setTextBrand(String value) {
		this.ebayPage.setTextBrand(value);
	}
	
	public void clickCheckButton1() {
		this.ebayPage.clickCheckButton1();
	}
	
	public void clickCheckPu() {
		this.ebayPage.clickCheckPu();
	}

	public void clickApply() {
		this.ebayPage.clickApply();
	}
	
	public void clickCheckButton2() {
		this.ebayPage.clickCheckButton2();
	}
	
	public boolean resultsAreDisplayed() {
		return this.ebayPage.getResults();
	}
	
	public void clickOrder() {
		this.ebayPage.clickOrder();
	}
	
	public void setTextPrice(String value1,String value2) {
		this.ebayPage.setTextPrice(value1,value2);
	}


}
