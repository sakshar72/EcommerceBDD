package stepDefinations;

import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import enums.Context;
import objectRepository.MobilePageObjects;
import resources.UtilityFunctions;

public class MobilePage_Steps extends UtilityFunctions {
	TestContext testContext;
	MobilePageObjects MobilePageObject;
	SoftAssert softAssertObj;
	Properties propertiesObj;
	Select selectObject;
	String sonyXperiaListingPrice;
	String sonyXperiaDesriptionPrice;
	ArrayList<String> productArray = new ArrayList<String>();

	public MobilePage_Steps(TestContext context) {
		testContext = context;
		MobilePageObject = testContext.getPageObjectManager().getMobilePage();

	}

	@Then("^Verfiy title of the Page$")
	public void verfiy_title_of_the_Page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		softAssertObj = softAssertObject();
		propertiesObj = propertiesFileLoad();
		softAssertObj.assertEquals(driverObject.getTitle(), propertiesObject.getProperty("mobilePageTitle"));
		softAssertObj.assertAll();

	}

	@And("^Select SORT BY name in the dropdown$")
	public void select_sort_by_name_in_the_dropdown() throws Throwable {
		selectObject = selectObject(MobilePageObject.sendObjectSortByDropdown());
		selectObject.selectByIndex(1);
	}

	@Then("^Read the cost of Sony Xperia Mobile $")
	public void read_the_cost_of_sony_xperia_mobile() throws Throwable {
		sonyXperiaListingPrice = MobilePageObject.sendProductPrice().getText();
	}

	@And("^Click on Sony Xperia Mobile$")
	public void click_on_sony_xperia_mobile() throws Throwable {
		try {

			MobilePageObject.sendObjectSonyXperiaSelectProduct().click();

		} catch (Exception e) {
			softAssertObj.assertAll();
		}
	}

	@Then("^Read the Price of Sony Xperia Mobile from Details Page $")
	public void read_the_price_of_sony_xperia_mobile_from_details_page() throws Throwable {
		sonyXperiaDesriptionPrice = MobilePageObject.sendObjectXperiaProductPrice().getText();
	}

	@And("^Verify the two values to be equal $")
	public void verify_the_two_values_to_be_equal() throws Throwable {
		softAssertObj.assertEquals(sonyXperiaListingPrice, sonyXperiaDesriptionPrice, "Value mismatch");
	}

	@Then("^User click on Add To Cart button$")
	public void user_click_on_add_to_cart_button() throws Throwable {
		System.out.println("Product to added " + MobilePageObject.sendObjectSonyXperiaProductName().getText());
		testContext.scenarioContext.setContext(Context.product_Name,
				MobilePageObject.sendObjectSonyXperiaProductName().getText());
		MobilePageObject.sendObjectAddToCart().click();
	}

	@Then("^Click on Add To Compare for 2 mobile$")
	public void click_on_add_to_compare_for_2_mobile() throws Throwable {
		softAssertObj = softAssertObject();
		MobilePageObject.sendObjectXperiaAddToCompareBtn().click();
		MobilePageObject.sendObjectIphoneAddToCompareBtn().click();
		for (int i = 0; i < MobilePageObject.sendObjectNumberOfItems().size(); i++) {
			productArray.add(MobilePageObject.sendObjectProductHeading().get(i).getText());
			softAssertObj.assertEquals(MobilePageObject.sendObjectProductHeading().get(i).getText(),
					MobilePageObject.sendObjectHeadingOfItemToCompare().get(i).getText(),
					"Incorrect Product Are getting added");
		}
		softAssertObj.assertAll();

	}

	@Then("^Click on Compare Button$")
	public void click_on_compare_button() throws Throwable {
		MobilePageObject.sendObjectCompareBtn().click();
	}

	@Then("^Verify popup and products$")
	public void verify_popup_and_products() throws Throwable {
		String mainWindowHandle = handlingMultipleWindows(driverObject);
		System.out.println("value of size " + MobilePageObject.popupProductNeading.size());
		for (int j = 0; j < MobilePageObject.popupProductNeading.size(); j++) {
			softAssertObj.assertEquals(MobilePageObject.popupProductNeading.get(j).getText(), productArray.get(j),
					"Pop up products are not matching");
		}
		softAssertObj.assertAll();
	}

}
