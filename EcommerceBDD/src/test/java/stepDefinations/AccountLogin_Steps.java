package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import objectRepository.AccountLoginPageObjects;
import pageObjectManagers.PageObjectManager;
import resources.UtilityFunctions;

public class AccountLogin_Steps extends UtilityFunctions {
	PageObjectManager pageObjectManagerObject;
	AccountLoginPageObjects AccountLoginPageObject;
	Properties propertyObject;
	SoftAssert softAssertObject;
	TestContext testContext;
	Actions actionObject;

	public AccountLogin_Steps(TestContext context) throws IOException {
		testContext = context;
		AccountLoginPageObject = testContext.getPageObjectManager().getAccountLoginPage();
		propertyObject = propertiesFileLoad();
		actionObject = actionObject(driverObject);

	}

	@Then("^User Click on Create Account Button$")
	public void user_click_on_create_account_button() throws Throwable {
		AccountLoginPageObject.sendObjectCreateAccountBtn().click();
	}

	@Then("^User enter login credentials$")
	public void user_enter_login_credentials() throws Throwable {
		actionObject.click(AccountLoginPageObject.sendObjectEmailIdInputField())
				.sendKeys(propertyObject.getProperty("emailAddress")).sendKeys(Keys.TAB).build().perform();
		AccountLoginPageObject.sendObjectPassowrdInputField().sendKeys(propertyObject.getProperty("password"));
	}

	@And("^click on Login Button$")
	public void click_on_login_button() throws Throwable {
		AccountLoginPageObject.sendObjectLoginBtn().click();
	}

	@Then("^Verify the user creentials$")
	public void verify_the_user_creentials() throws Throwable {

		try {
			AccountLoginPageObject.sendObjectUserEmailIdErrorMessage().isDisplayed();
			Assert.fail("Invalid Email ID");

		} catch (NoSuchElementException e) {

		}
		try {
			AccountLoginPageObject.sendObjectUserPasswordErrorMessage().isDisplayed();
			Assert.fail("Invalid password");

		} catch (NoSuchElementException e) {

		}
		try {
			AccountLoginPageObject.sendObjectLoginDetailsInvalidMessage().isDisplayed();
			Assert.fail("Invalid Login Credentials");
		} catch (NoSuchElementException e) {
		}

	}

}
