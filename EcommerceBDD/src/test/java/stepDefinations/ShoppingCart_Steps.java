package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import junit.framework.Assert;
import objectRepository.ShoppingCartObjects;
import resources.UtilityFunctions;

public class ShoppingCart_Steps extends UtilityFunctions {
	TestContext testContext;
	ShoppingCartObjects ShoppingCartObject;
	Actions actionObject;
	Properties propertyObject;

	public ShoppingCart_Steps(TestContext context) throws IOException {
		testContext = context;
		ShoppingCartObject = testContext.getPageObjectManager().getShoppingCartPage();
		softAssertObject = softAssertObject();
		propertyObject = propertiesFileLoad();
		actionObject = actionObject(driverObject);

	}

	@Then("^User change the QTY value to 1000$")
	public void user_change_the_qty_value_to_1000() throws Throwable {
		actionObject.click(ShoppingCartObject.sendObjectProductQuantityInputField()).sendKeys("1000").build().perform();
		if (ShoppingCartObject.sendObjectUpdateBtn().isDisplayed()) {
			ShoppingCartObject.sendObjectUpdateBtn().click();
		}

	}

	@Then("^Verify the Error Message$")
	public void verify_the_error_message() throws Throwable {

		if (ShoppingCartObject.sendObjectProductLimitErrorMessage().isDisplayed()) {
			softAssertObject.assertEquals(propertyObject.getProperty("ProductErrorMessage"),
					ShoppingCartObject.sendObjectProductLimitErrorMessage().getText(), "String mismatch");

			System.out.println("inside limit error message");
		}
		softAssertObject.assertAll();

	}

	@Then("^Verfiy Cart is Empty$")
	public void verfiy_cart_is_empty() throws Throwable {

		ShoppingCartObject.sendObjectEmptyCartBtn().click();
		if (ShoppingCartObject.sendObjectEmptyCartMessage().isDisplayed()) {
			softAssertObject.assertEquals(propertyObject.getProperty("cartEmptyMessage"),
					ShoppingCartObject.sendObjectEmptyCartMessage().getText(), "Cart is not Empty Error Message");
		}
		softAssertObject.assertAll();

	}

	@SuppressWarnings("deprecation")
	@Then("^verify same product is added to the cart$")
	public void verify_same_product_is_added_to_the_cart() throws Throwable {
		try {
			System.out.println("Inside try block");
			String productName = testContext.scenarioContext.getContext(Context.product_Name).toString();
			System.out.println("Product added " + productName);
			System.out.println("screen message " + ShoppingCartObject.sendObjectProductAddedSuccessMessage().getText());
			ShoppingCartObject.sendObjectProductAddedSuccessMessage().getText().contains(productName);
			ShoppingCartObject.sendObjectProceedToCheckoutBtn().click();
		} catch (Exception e) {
			System.out.println("Inside catch block");
			Assert.fail("Prodcut is different");
		}

	}

	@Then("^Verify the product name to be reordered$")
	public void verify_the_product_name_to_be_reordered() throws Throwable {
		System.out.println("product value " + ShoppingCartObject.sendObjectProductName().getText());
		softAssertObject.assertEquals(ShoppingCartObject.sendObjectProductName().getText(),
				testContext.scenarioContext.getContext(Context.product_Name), "Product name not mtchig");
		softAssertObject.assertAll();
	}

	@SuppressWarnings("deprecation")
	@Then("^change the product quantity$")
	public void change_the_product_quantity() throws Throwable {
		actionObject.click(ShoppingCartObject.sendObjectProductQuantityInputField()).sendKeys(Keys.BACK_SPACE)
				.sendKeys("2").build().perform();
		ShoppingCartObject.sendObjectProductQuantityUpdateBtn().click();

	}

	@SuppressWarnings("deprecation")
	@Then("^Verify the Product quantity and Price$")
	public void verify_the_product_quantity_and_price() throws Throwable {
		try {
			ShoppingCartObject.sendObjectQuantityErrorMessage().isDisplayed();
			Assert.fail("Quantity cannot be more than 500");
		} catch (Exception e) {

		}
		String productPrice = ShoppingCartObject.sendObjectproductPrice().getText();
		System.out.println("Substring is " + productPrice.substring(1));
		String subString = productPrice.substring(1);
		productPrice = subString.replace(",", "");
		System.out.println("Product Pirce after replaicng " + productPrice);
		float price = Float.parseFloat(productPrice);
		System.out.println("value of product " + price);
		System.out.println("output value " + price / 615.0);
		if (price % 615.0 == 0) {
			System.out.println("inside if ");
			ShoppingCartObject.sendObjectProceedToCheckoutBtn().click();
		} else {
			Assert.fail("Value is incorrect");
		}

	}

}
