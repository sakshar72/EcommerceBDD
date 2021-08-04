package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.NoSuchElementException;
import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import objectRepository.WishlistPageObjects;
import pageObjectManagers.PageObjectManager;
import resources.UtilityFunctions;
import enums.Context;
import junit.framework.Assert;

public class WishListPage_Steps extends UtilityFunctions {
	PageObjectManager pageObjectManagerObject;
	Properties propertyObject;
	SoftAssert softAssertObject;
	TestContext testContext;
	WishlistPageObjects WishlistPageObject;

	public WishListPage_Steps(TestContext context) throws IOException {
		testContext = context;
		WishlistPageObject = testContext.getPageObjectManager().getWishListPage();
		softAssertObject = softAssertObject();
		propertyObject = propertiesFileLoad();

	}

	@Then("^Verfiy the same product is added$")
	public void verfiy_the_same_product_is_added() throws Throwable {
		System.out.println(
				"value of product added " + testContext.scenarioContext.getContext(Context.product_Name).toString());
		softAssertObject.assertEquals(WishlistPageObject.sendObjectWishListProductName().getText(),
				testContext.scenarioContext.getContext(Context.product_Name), "Product didn't match");
		softAssertObject.assertAll();
	}

	@SuppressWarnings("deprecation")
	@Then("^click on wishlist share button$")
	public void click_on_wishlist_share_button() throws Throwable {
		WishlistPageObject.sendObjectShareWishlistBtn().click();
		WishlistPageObject.sendObjectWishListEmailBox().sendKeys(propertyObject.getProperty("wishListShareEmail"));

	}

	@SuppressWarnings("deprecation")
	@And("^Validate Wishlist is shared successfully$")
	public void validate_wishlist_is_shared_successfully() throws Throwable {
		WishlistPageObject.sendObjectShareWishlistBtn().click();
		try {
			WishlistPageObject.sendObjecIncorrectEmailError().isDisplayed();
			Assert.fail("Incorrect Email Address Format");
		} catch (NoSuchElementException e) {
			softAssertObject.assertEquals(propertyObject.getProperty("WishlistShareSuccessMessage"),
					WishlistPageObject.sendObjectWishlistShareSuccessMessage().getText(), "Wishlist Not shared ");
			softAssertObject.assertAll();
		}
	}

	@Then("^user click on Add to Cart link$")
	public void user_click_on_add_to_cart_link() throws Throwable {
		WishlistPageObject.sendObjectAddToCartBtn().click();
	}

}
