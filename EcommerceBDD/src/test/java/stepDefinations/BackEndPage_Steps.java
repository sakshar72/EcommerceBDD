package stepDefinations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import junit.framework.Assert;
import objectRepository.BackendPageObjects;
import pageObjectManagers.PageObjectManager;
import resources.UtilityFunctions;

public class BackEndPage_Steps extends UtilityFunctions {
	PageObjectManager pageObjectManagerObject;
	Properties propertyObject;
	SoftAssert softAssertObject;
	TestContext testContext;
	BackendPageObjects BackendPageObject;
	Actions actionObject;

	public BackEndPage_Steps(TestContext context) throws IOException {
		testContext = context;
		BackendPageObject = testContext.getPageObjectManager().getbackendPage();
		propertyObject = propertiesFileLoad();
		softAssertObject = softAssertObject();
		actionObject = actionObject(driverObject);
		Select selectObject;
	}

	@Then("^Go to backend URL$")
	public void go_to_backend_url() throws Throwable {
		driverObject.get(propertyObject.getProperty("backEndURL"));
	}

	@Then("^Enter the backend Login credentials$")
	public void enter_the_backend_login_credentials() throws Throwable {
		actionObject.click(BackendPageObject.sendObjectUsernameLoginField())
				.sendKeys(propertyObject.getProperty("emailAddressBackEnd")).sendKeys(Keys.TAB).build().perform();
		BackendPageObject.sendObjectPasswordLoginField().sendKeys(propertyObject.getProperty("passwordBackEnd"));
		BackendPageObject.sendObjectLoginBtn().click();
	}

	@SuppressWarnings("deprecation")
	@Then("^Verify backend user credentials$")
	public void verify_backend_user_credentials() throws Throwable {
		try {
			BackendPageObject.sendObjectPassowrdErroMessage().isDisplayed();
			Assert.fail("Password Is Required");
		} catch (Exception e) {

		}
		try {
			BackendPageObject.sendObjectUserNameErroMessage().isDisplayed();
			Assert.fail("Username is Required");
		} catch (Exception e) {

		}
		try {
			BackendPageObject.sendObjectIncorrectCredentialsErroMessage().isDisplayed();
			Assert.fail("Incorrect Credentials");
		} catch (Exception e) {

		}

	}

	@Then("^go to pending reviews menu$")
	public void go_to_pending_reviews_menu() throws Throwable {
		BackendPageObject.sendObjectPopUpCloseBtn().click();
		actionObject.moveToElement(BackendPageObject.sendObjectCatalogNavLink())
				.moveToElement(BackendPageObject.sendObjectReviewRatingLink())
				.moveToElement(BackendPageObject.sendObjectCustomerReviewLink())
				.moveToElement(BackendPageObject.sendObjectReviewPendingLink()).click().build().perform();
	}

	@SuppressWarnings("deprecation")
	@Then("^Verify the product are sorted by ID$")
	public void verify_the_product_are_sorted_by_id() throws Throwable {
		ArrayList<Integer> orderID = new ArrayList<Integer>();
		for (int i = 0; i < BackendPageObject.sendObjectIDNumbers().size(); i++) {
			orderID.add(Integer.parseInt(BackendPageObject.IDNumbers.get(i).getText()));
		}
		for (int i = 0; i < BackendPageObject.sendObjectIDNumbers().size(); i++) {
			if(i!=BackendPageObject.sendObjectIDNumbers().size()-1) {
				if (orderID.get(i) < orderID.get(i + 1)) {
					Assert.fail("Order ID list is not sorted");
				}
			}
			
		}

	}

	@Then("^click on edit comment link$")
	public void click_on_edit_comment_link() throws Throwable {
		BackendPageObject.sendObjectEditCommentLink().click();
	}

	@Then("^change the status to Approved$")
	public void change_the_status_to_approved() throws Throwable {
		selectObject(BackendPageObject.sendObjectStatusDropdown()).selectByVisibleText("Approved");
	}

	@Then("^click on Save Review button$")
	public void click_on_save_review_button() throws Throwable {
		BackendPageObject.sendObjectSaveReviewBtn().click();
	}

	@Then("^Veirfy the review is saved$")
	public void veirfy_the_review_is_saved() throws Throwable {
		softAssertObject.assertEquals(BackendPageObject.sendObjectReviewSavedSuccessMessage().getText(),
				propertyObject.getProperty("reviewSavedSuccessMessage"), "Message is not saved");
		softAssertObject.assertAll();
	}

}
