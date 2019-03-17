package systemAcceptanceTests.pageObject;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class GitHubPage extends PageObject{
	private final String GIT_HUB_PAGE = "https://github.com/";
	private final String SIGN_IN_BTN_XPATH = "/html/body/div[1]/header/div/div[2]/div[2]/a[1]";
	private final String USERNAME_FIELD_ID = "login_field";
	private final String PASSWORD_FIELD_ID = "password";
	private final String LOG_IN_BTN_XPATH = "//*[@id=\"login\"]/form/div[3]/input[3]";
	private final String REPOSITORIES_LABEL_XPATH = "/html/body/div[4]/div/aside[1]/div[2]/div/div/h2";
	
	private WebElement signInBtn;
	private WebElement usernameField;
	private WebElement passwordField;
	private WebElement logInBtn;
  	private WebElement repositoriesLabel;
  	
	public void goToGitHubPage() {
		this.goToPage(this.GIT_HUB_PAGE);
		try {
			this.takeScreenShot("gitHome");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Can't take a photo. In goToGitHubPage().");
		}
	}
	
	public void goToLoginPage() {
		this.signInBtn = this.findByXpath(SIGN_IN_BTN_XPATH);
		this.signInBtn.click();
		try {
			this.takeScreenShot("gitLogin");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Can't take a photo. In goToLoginPage().");
		}
	}
	
	public void enterUserName() {
		this.usernameField = this.findById(USERNAME_FIELD_ID);
		this.usernameField.sendKeys("HostAbroad");
	}
	
	public void enterPassword() {
		this.passwordField = this.findById(this.PASSWORD_FIELD_ID);
		this.passwordField.sendKeys("TravelerHost@1");
	}
	
	public void clickSignIn() {
		this.logInBtn = this.findByXpath(this.LOG_IN_BTN_XPATH);
		this.logInBtn.click();
		try {
			this.takeScreenShot("gitAllFieldsFilled");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Can't take a photo. In clickSignIn().");
		}
	}
	
	public String checkSuccessfulLogin() {
		try {
			this.takeScreenShot("gitRepositories");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Can't take a photo. In checkSuccessfulLogin().");
		}
		this.repositoriesLabel = this.findByXpath(this.REPOSITORIES_LABEL_XPATH);
		String res = this.repositoriesLabel.getText().substring(0, 12);
		System.out.println(res);
		this.quitDriver();
		return res;
	}

}
