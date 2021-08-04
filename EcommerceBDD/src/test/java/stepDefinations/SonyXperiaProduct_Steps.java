package stepDefinations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import objectRepository.MobilePageObjects;
import objectRepository.SonyXperiaProductPageObjects;
import resources.UtilityFunctions;

public class SonyXperiaProduct_Steps extends UtilityFunctions {
	TestContext testContext;
	MobilePageObjects MobilePageObject;
	SoftAssert softAssertObj;
	Properties propertiesObj;
	Select selectObject;
	String sonyXperiaListingPrice;
	String sonyXperiaDesriptionPrice;
	SonyXperiaProductPageObjects SonyXperiaProductPageObject;
	ArrayList<String> productArray = new ArrayList<String>();

	public SonyXperiaProduct_Steps(TestContext context) throws IOException {
		testContext = context;
		SonyXperiaProductPageObject = testContext.getPageObjectManager().getSonyXperiaPage();
		propertiesObj = propertiesFileLoad();
		softAssertObject = softAssertObject();

	}

	@Then("^click on review Tab$")
	public void click_on_review_tab() throws Throwable {
		SonyXperiaProductPageObject.sendObjectReviewTablink().click();
	}

	@Then("^compare review comment$")
	public void compare_review_comment() throws Throwable {
		int count = 0;
		for (int i = 0; i < SonyXperiaProductPageObject.sendObjectReviewHeadings().size(); i++) {
			if (propertiesObj.getProperty("productReviewField")
					.equalsIgnoreCase(SonyXperiaProductPageObject.sendObjectReviewHeadings().get(i).getText())) {
				count++;
				break;
			}
		}
		if (count == 0) {
			Assert.fail("Comment is not present");
		} else {
			System.out.println("Comment added successsfully !!! ");
		}
	}
}
