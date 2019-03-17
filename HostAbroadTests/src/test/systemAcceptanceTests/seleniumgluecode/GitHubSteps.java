package systemAcceptanceTests.seleniumgluecode;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import systemAcceptanceTests.pageObject.GitHubPage;

public class GitHubSteps {
	
	private GitHubPage git = new GitHubPage();
	
	@Given("^user is on GitHub page$")
	public void user_is_on_GitHub_page() throws Throwable {
		git.goToGitHubPage();
	}

	@When("^user navigates to Login Page$")
	public void user_navigates_to_Login_Page() throws Throwable {
		git.goToLoginPage();
	}

	@When("^user enters username and Password$")
	public void user_enters_username_and_Password() throws Throwable {
		git.enterUserName();
		git.enterPassword();
		git.clickSignIn();
	}

	@Then("^user sees their repositories$")
	public void user_sees_their_repositories() throws Throwable {
        assertEquals(git.checkSuccessfulLogin(), "Repositories");
	}
}
