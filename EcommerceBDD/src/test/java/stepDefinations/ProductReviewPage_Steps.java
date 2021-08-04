package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import objectRepository.ReviewPageObjects;
import pageObjectManagers.PageObjectManager;
import resources.UtilityFunctions;

public class ProductReviewPage_Steps extends UtilityFunctions {
	PageObjectManager pageObjectManagerObject;
	Properties propertyObject;
	SoftAssert softAssertObject;
	TestContext testContext;
	ReviewPageObjects ReviewPageObject;
	Actions actionObject;

	public ProductReviewPage_Steps(TestContext context) throws IOException {
		testContext = context;
		ReviewPageObject = testContext.getPageObjectManager().getProductReviewPage();
		propertyObject = propertiesFileLoad();
		softAssertObject = softAssertObject();
		actionObject = actionObject(driverObject);
	}

	@Then("^User submit the review$")
	public void user_submit_the_review() throws Throwable {
		ReviewPageObject.sendObjectQualityCheckBox().click();
		actionObject.click(ReviewPageObject.sendObjectReviewField())
				.sendKeys(propertyObject.getProperty("productReviewField")).sendKeys(Keys.TAB).build().perform();
		actionObject.sendKeys(propertyObject.getProperty("summaryReviewField")).sendKeys(Keys.TAB).build().perform();
		actionObject.sendKeys(propertyObject.getProperty("nicknamefield")).build().perform();
		ReviewPageObject.sendObjectSubmitReviewBtn().click();
	}

	@Then("^verfiy the user comment$")
	public void verfiy_the_user_comment() throws Throwable {
		try {
			ReviewPageObject.sendObjectQualityCheckboxError().isDisplayed();
			Assert.fail("Checkbox is mandatory field");
		} catch (Exception e) {

		}
		try {
			ReviewPageObject.sendObjectReviewFieldError().isDisplayed();
			Assert.fail("Review Field is mandatory field");
		} catch (Exception e) {

		}
		try {
			ReviewPageObject.sendObjectSummaryFieldError().isDisplayed();
			Assert.fail("Summary Field is mandatory field");
		} catch (Exception e) {

		}
		try {
			ReviewPageObject.sendObjectNickNameFieldError().isDisplayed();
			Assert.fail("Nickname Field is mandatory field");
		} catch (Exception e) {

		}
		softAssertObject.assertEquals(ReviewPageObject.sendObjectReviewSuccessMessage().getText(),
				propertyObject.getProperty("reviewSuccessMessage"), "Review Not submiteed");
		softAssertObject.assertAll();
	}

}
