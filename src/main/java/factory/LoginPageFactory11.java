package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory11 {
	private WebDriver driver;
	@FindBy(id = "username")
	private WebElement usernameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "submit")
	private WebElement loginButton;

	public LoginPageFactory11(WebDriver driver) {
		this.driver = driver;
		// Initialize elements with PageFactory
		PageFactory.initElements(driver, this);
	}

	// Page Actions
	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

}
