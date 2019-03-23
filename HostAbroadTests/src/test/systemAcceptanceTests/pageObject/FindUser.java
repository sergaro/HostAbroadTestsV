package systemAcceptanceTests.pageObject;

import org.openqa.selenium.WebElement;

public class FindUser extends PageObject{
	//this will be changed when we put an id to this checkbox
	private final String CHECKBOX_HOST_XPATH = "//*[@id=\"HostAbroadsearch-949127791\"]/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div[1]/span/label";
	private final String ACCEPT_BTN_XPATH = "//*[@id=\"HostAbroadsearch-949127791\"]/div/div[2]/div/div/div/div[3]/div/div/div/div/div/div/div[2]/div/div[3]/div";
	//all of the selecting constants  should be modified 
	private final String RESULTFIRST_XPATH = "//*[@id=\"HostAbroadsearch-949127791\"]/div/div[2]/div/div/div/div[3]/div/div/div[3]/div/div[1]/div/div[2]/div";
	
	private WebElement checkBoxHost;
	private WebElement acceptBtn;
	private WebElement resultFirst;

	public void findSelectHostCheckBoxAndClickIt() {
		this.checkBoxHost = this.findByXpath(this.CHECKBOX_HOST_XPATH);
		this.checkBoxHost.click();
	}

	public void clickApply() {
		this.acceptBtn = this.findByXpath(this.ACCEPT_BTN_XPATH);
		this.acceptBtn.click();
	}

	public boolean checkSearchHost() {
		this.resultFirst = this.findByXpath(this.RESULTFIRST_XPATH);
		boolean result = this.resultFirst.isDisplayed();
		this.quitDriver();
		return result;
	}
	
	public boolean checkSearchHostNoResults() {
		this.resultFirst = this.findByXpath(this.RESULTFIRST_XPATH);
		boolean result = this.resultFirst.isDisplayed();
		return !result;
	}
	

	public String getNoResultErrorMessage() {
		String result = "";
		
		return result;
	}

}
