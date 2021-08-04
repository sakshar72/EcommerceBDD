package stepDefinations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import cucumber.TestContext;
import cucumber.api.java.en.Then;
import objectRepository.AdvanceSearchPageObjects;
import pageObjectManagers.PageObjectManager;
import resources.UtilityFunctions;

public class SearchPage_Steps extends UtilityFunctions {
	PageObjectManager pageObjectManagerObject;
	AdvanceSearchPageObjects AdvanceSearchPageObject;
	Properties propertyObject;
	SoftAssert softAssertObject;
	TestContext testContext;
	Actions actionObject;

	public SearchPage_Steps(TestContext context) throws IOException {
		testContext = context;
		AdvanceSearchPageObject = testContext.getPageObjectManager().getAdvancedSearchPage();
		propertyObject = propertiesFileLoad();
		softAssertObject = softAssertObject();
		actionObject = actionObject(driverObject);
	}

	@Then("^user provide price value$")
	public void user_provide_price_value() throws Throwable {
		actionObject.click(AdvanceSearchPageObject.sendObjectPriceInputField()).sendKeys("0").sendKeys(Keys.TAB).build()
				.perform();
		AdvanceSearchPageObject.sendObjectPriceToInputField().sendKeys("150");
		AdvanceSearchPageObject.sendObjectSearchButton().click();
	}

	@Then("^Verfiy search input are valid$")
	public void verfiy_search_input() throws Throwable {
		try {
			AdvanceSearchPageObject.sendObjectSearchFieldErrorMessage().isDisplayed();
			Assert.fail("Atleat input one search parameter");
		} catch (Exception e) {

		}
		try {
			AdvanceSearchPageObject.sendObjectModifySearchErrorMessage().isDisplayed();
			Assert.fail("Modify your search");
		} catch (Exception e) {

		}
	}

	@Then("^verify the product are within the range$")
	public void verify_the_product_are_within_the_range() throws Throwable {
		float firstListProductPrice = Float
				.parseFloat(AdvanceSearchPageObject.sendObjectFirstProductPrice().getText().substring(1));
		float secondListProductPrice = Float
				.parseFloat(AdvanceSearchPageObject.sendObjectSecondProductPrice().getText().substring(1));
		ArrayList<Float> searchProductPrice = new ArrayList<Float>();
		searchProductPrice.add(firstListProductPrice);
		searchProductPrice.add(secondListProductPrice);
		for (int i = 0; i < searchProductPrice.size(); i++) {
			if (searchProductPrice.get(i) > 150) {
				Assert.fail("Range of product is not within 0 -150 correct");
			}
		}
	}

}
