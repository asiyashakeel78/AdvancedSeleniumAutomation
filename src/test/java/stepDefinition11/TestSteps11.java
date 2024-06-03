package stepDefinition11;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import basePage.BasePage11;
import factory.LoginPageFactory11;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ScreenshotUtility;

public class TestSteps11 {
	public WebDriver driver;
	private LoginPageFactory11 loginPage;


	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
		driver = BasePage11.getDriver("edge");
		driver.get("https://practicetestautomation.com/practice-test-login/");
		loginPage = new LoginPageFactory11(driver);	 	    
	}


	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		loginPage.enterUsername("student");
		loginPage.enterPassword("Password123"); 	    
	}


	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginPage.clickLoginButton();    

	}

	@Then("user is navigated to the dashboard page")
	public void user_is_navigated_to_the_dashboard_page() {

		String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
		String actualUrl = loginPage.getCurrentUrl();
		try {
			Assert.assertEquals(actualUrl, expectedUrl, "User is not on the expected login page URL.");
		} catch (AssertionError e) {
			ScreenshotUtility.takeScreenshot(driver, "screenshots/failure-screenshot.png");
			throw e;  // Rethrow to allow Cucumber to handle the failure
		} finally {
			driver.quit();
		}


	}


}
