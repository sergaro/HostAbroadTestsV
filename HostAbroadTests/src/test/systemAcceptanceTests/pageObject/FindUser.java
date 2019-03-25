package systemAcceptanceTests.pageObject;

import org.openqa.selenium.WebElement;

public class FindUser extends PageObject{
	private final String CHECKBOX_HOST_ID = "checkBoxHost";
	private final String ACCEPT_BTN_ID = "acceptButton";
	private final String RESULTFIRST_ID = "card1";
	private final String RESULT_NOTIFICACION_CLASS = ".v-Notification-caption";
	private final String NO_USERS_MESSAGE = "There are no users matching your criteria.";
	
	private WebElement checkBoxHost;
	private WebElement acceptBtn;
	private WebElement resultFirst;
	private WebElement resultNotification;

	public void findSelectHostCheckBoxAndClickIt() {
		this.checkBoxHost = this.findById(this.CHECKBOX_HOST_ID);
		this.checkBoxHost.click();
	}

	public void clickApply() {
		this.acceptBtn = this.findById(this.ACCEPT_BTN_ID);
		this.acceptBtn.click();
	}

	public boolean checkSearchHost() {
		this.resultFirst = this.findById(this.RESULTFIRST_ID);
		boolean result = this.resultFirst.isDisplayed();
		this.quitDriver();
		return result;
	}
	
	public boolean checkEmptyResults() {
		this.resultNotification = this.findByCssSelector(RESULT_NOTIFICACION_CLASS);
		String resultText = this.resultNotification.getText();
		this.quitDriver();
		return resultText.equals(this.NO_USERS_MESSAGE);
	}

}
