package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import objectRepository.CreateAccountPageObjects;
import pageObjectManagers.PageObjectManager;
import resources.UtilityFunctions;

public class CreateAccount_Steps extends UtilityFunctions {
	PageObjectManager pageObjectManagerObject;
	Properties propertyObject;
	SoftAssert softAssertObject;
	TestContext testContext;
	CreateAccountPageObjects CreateAccountPageObject;
	Actions actionObject;

	public CreateAccount_Steps(TestContext context) throws IOException {
		testContext = context;
		CreateAccountPageObject = testContext.getPageObjectManager().getCreateAccountLoginPage();
		propertyObject = propertiesFileLoad();
		actionObject = actionObject(driverObject);
		softAssertObject = softAssertObject();

	}

	@SuppressWarnings("deprecation")
	@Then("^User Enter the details$")
	public void user_enter_the_details() throws Throwable {
		actionObject.click(CreateAccountPageObject.sendObjectFirstName())
				.sendKeys(propertyObject.getProperty("firstName")).sendKeys(Keys.TAB).build().perform();
		actionObject.sendKeys(propertyObject.getProperty("middleName")).sendKeys(Keys.TAB).build().perform();
		actionObject.sendKeys(propertyObject.getProperty("lastName")).sendKeys(Keys.TAB).build().perform();
		actionObject.sendKeys(propertyObject.getProperty("emailAddress")).sendKeys(Keys.TAB).build().perform();
		actionObject.sendKeys(propertyObject.getProperty("password")).sendKeys(Keys.TAB).build().perform();
		actionObject.sendKeys(propertyObject.getProperty("confirmPassword")).build().perform();
		CreateAccountPageObject.sendObjectRegisterBtn().click();

		try {
			CreateAccountPageObject.sendObjectLoginFailedErrorMessage().isDisplayed();
			Assert.fail("Account already exist");
		} catch (Exception e) {

		}
		try {
			CreateAccountPageObject.sendObjectConfirmPasswordRequiredFieldError().isDisplayed();
			Assert.fail("Confirm Password Field Missing");
		} catch (Exception e) {

		}
		try {
			CreateAccountPageObject.sendObjectEmailMandatoryFieldError().isDisplayed();
			Assert.fail("Email Field Missing");
		} catch (Exception e) {

		}
		try {
			CreateAccountPageObject.sendObjectLastNameRequiredFieldError().isDisplayed();
			Assert.fail("Last Name Field Missing");
		} catch (Exception e) {

		}
		try {
			CreateAccountPageObject.sendObjectPasswordMismatchFieldError().isDisplayed();
			Assert.fail("Password Mismatch");
		} catch (Exception e) {

		}

		try {
			CreateAccountPageObject.sendObjectPasswordRequiredFieldError().isDisplayed();
			Assert.fail("Password Field Missing");
		} catch (Exception e) {

		}

		try {
			CreateAccountPageObject.sendObjectUsernameRequiredFieldError().isDisplayed();
			Assert.fail("Username Field Missing");
		} catch (Exception e) {

		}

	}

	@Then("^Verfiy User Account is created$")
	public void verfiy_user_account_is_created() throws Throwable {
		System.out.println("Insided Step");
		System.out.println("value of step" + CreateAccountPageObject.sendObjectAccountCreatedMessage().getText());
		softAssertObject.assertEquals(CreateAccountPageObject.sendObjectAccountCreatedMessage().getText(),
				propertyObject.getProperty("accountCreatedMessage"), "Account not created");
		CreateAccountPageObject.sendObjectTvNavLink().click();
		softAssertObject.assertAll();
		System.out.println("Last Step");
	}
}
