package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import objectRepository.TVPageObjects;
import pageObjectManagers.PageObjectManager;

public class TVPage_Steps {
	PageObjectManager pageObjectManagerObject;
	Properties propertyObject;
	SoftAssert softAssertObject;
	TestContext testContext;
	TVPageObjects tvPageObject;
	String tvProductSelected;
	String tvPrice;

	public TVPage_Steps(TestContext context) throws IOException {
		testContext = context;
		tvPageObject = testContext.getPageObjectManager().getTVPage();
	}

	@Then("^User Add the product to wishlist$")
	public void user_add_the_product_to_wishlist() throws Throwable {
		tvProductSelected = tvPageObject.sendObjectTVProduct();
		tvPrice = tvPageObject.sendObjectTVPrice();
		System.out.println("Product selected " + tvProductSelected);
		System.out.println("Product selected " + tvPrice);
		testContext.scenarioContext.setContext(Context.product_Name, tvProductSelected);
		testContext.scenarioContext.setContext(Context.product_Price, tvPrice);
		tvPageObject.sendObjectAddToWishlistBtn().click();
	}
}
