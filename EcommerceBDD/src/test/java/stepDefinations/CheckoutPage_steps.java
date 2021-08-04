package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import enums.Context;
import objectRepository.CheckoutPageObjects;
import resources.UtilityFunctions;

public class CheckoutPage_steps extends UtilityFunctions {
	TestContext testContext;
	CheckoutPageObjects CheckoutPageObject;
	Actions actionObject;
	Properties propertyObject;
	SoftAssert softAssertObject;
	Select selectObject;

	public CheckoutPage_steps(TestContext context) throws IOException {
		testContext = context;
		CheckoutPageObject = testContext.getPageObjectManager().getCheckoutPage();
		softAssertObject = softAssertObject();
		propertyObject = propertiesFileLoad();
		actionObject = actionObject(driverObject);

	}

	@Then("^enter the billing details$")
	public void enter_the_billing_details() throws Throwable {
		actionObject.click(CheckoutPageObject.sendObjectBillingAddressInputField())
				.sendKeys(propertyObject.getProperty("billingAddress")).build().perform();
		actionObject.click(CheckoutPageObject.sendObjectBillingAddressSecondField())
				.sendKeys(propertyObject.getProperty("billingAddress")).sendKeys(Keys.TAB).build().perform();
		actionObject.click(CheckoutPageObject.sendObjectBillingCityInputField())
				.sendKeys(propertyObject.getProperty("city")).build().perform();
		selectObject = selectObject(CheckoutPageObject.sendObjectStateDropdown());
		selectObject.selectByIndex(1);
		actionObject.click(CheckoutPageObject.sendObjectPincodeInputField())
				.sendKeys(propertyObject.getProperty("pincode")).build().perform();
		actionObject.click(CheckoutPageObject.sendObjectTelephoneInputField())
				.sendKeys(propertyObject.getProperty("telephone")).build().perform();
		CheckoutPageObject.sendObjectBillingContainerContinueBtn().click();
	}

	@Then("^validate the error fields$")
	public void validate_the_error_fields() throws Throwable {
		try {
			CheckoutPageObject.sendObjectAddressFieldErrorMessage().isDisplayed();
			Assert.fail("Address field is required");
		} catch (Exception e) {

		}

		try {
			CheckoutPageObject.sendObjectCityFieldErrorMessage().isDisplayed();
			Assert.fail("City field is required");
		} catch (Exception e) {

		}

		try {
			CheckoutPageObject.sendObjectStateFieldErrorMessage().isDisplayed();
			Assert.fail("State field is required");
		} catch (Exception e) {

		}
		try {
			CheckoutPageObject.sendObjectPinCodeFieldErrorMessage().isDisplayed();
			Assert.fail("pincode field is required");
		} catch (Exception e) {

		}
	}

	@Then("^User click on Shipping information Continue button$")
	public void user_click_on_shipping_information_continue_button() throws Throwable {
		CheckoutPageObject.sendObjectShippingContinueBtn().click();
		CheckoutPageObject.sendObjectFlatRateContinueButton().click();
	}

	@Then("^User click on payment option$")
	public void user_click_on_payment_option() throws Throwable {
		CheckoutPageObject.sendObjectCheckMoneyPayment().click();
		CheckoutPageObject.sendObjectPaymentContinueBtn().click();
	}

	@Then("^verify the product name and price$")
	public void verify_the_product_name_and_price() throws Throwable {
		System.out.println("value of product added from check out page"
				+ testContext.scenarioContext.getContext(Context.product_Price).toString());
		System.out.println("value of product added frim check out page"
				+ testContext.scenarioContext.getContext(Context.product_Name).toString());
		softAssertObject.assertEquals(CheckoutPageObject.sendObjectProductName().getText(),
				testContext.scenarioContext.getContext(Context.product_Name), "Producr name not mtchig");
		softAssertObject.assertEquals(CheckoutPageObject.sendObjectProductPrice().getText(),
				testContext.scenarioContext.getContext(Context.product_Price), "Producr Price not mtchig");
		softAssertObject.assertAll();
	}

	@Then("^user click on place order button$")
	public void user_click_on_place_order_button() throws Throwable {
		CheckoutPageObject.sendObjectPlaceOrderBtn().click();
	}

	@Then("^verify order is placed successfully$")
	public void verify_order_is_placed_successfully() throws Throwable {
		softAssertObject.assertEquals(propertyObject.getProperty("orderSuccessMessage"),
				CheckoutPageObject.sendObjectOrderSuccessMessage().getText(), "order unsuccessful");
		softAssertObject.assertAll();
	}

	@Then("^click on Continue button$")
	public void click_on_continue_button() throws Throwable {
		CheckoutPageObject.sendObjectBillingContainerContinueBtn().click();
		CheckoutPageObject.sendObjectFlatRateContinueButton().click();
		CheckoutPageObject.sendObjectCheckMoneyPayment().click();
		CheckoutPageObject.sendObjectPaymentContinueBtn().click();
		CheckoutPageObject.sendObjectPlaceOrderBtn().click();
	}

	@Then("^user add the coupon code$")
	public void user_add_the_coupon_code() throws Throwable {
		actionObject.click(CheckoutPageObject.sendObjectDiscountCodeInputField())
				.sendKeys(propertyObject.getProperty("discountCode")).build().perform();

	}

	@And("^Click on Coupon code Apply button$")
	public void click_on_coupon_code_apply_button() throws Throwable {
		CheckoutPageObject.sendObjectDiscountCodeApplyBtn().click();
	}

	@Then("^Verify the coupon code$")
	public void verify_the_coupon_code() throws Throwable {
		try {
			CheckoutPageObject.sendObjectCouponCodeErrorMessage().isDisplayed();
			Assert.fail("Invalid Coupo Code");
		} catch (Exception e) {

		}
	}

	@Then("^Verify the discounted price$")
	public void verify_the_discounted_price() throws Throwable {
		String price = CheckoutPageObject.sendObjectTotalPrice().getText();
		price = price.substring(1);
		System.out.println("Vlaue of proce " + price);
		float value = Float.parseFloat(price);
		System.out.println("Vlaue of vlaue " + value);
		double calculatedDiscountValue = (5.0 / 100) * value;
		System.out.println("disoucnt value by calc " + calculatedDiscountValue);
		System.out.println(
				"Discount value from screen " + CheckoutPageObject.sendObjectDiscountValue().getText().substring(2));
		float disocuntValueDisplayed = Float.parseFloat(CheckoutPageObject.sendObjectDiscountValue().getText().substring(2));
		System.out.println("disocunt Value Displayed " + disocuntValueDisplayed);
		if(calculatedDiscountValue==disocuntValueDisplayed) {
			System.out.println("Code added Successfully");
		} else {
			Assert.fail("Disocunt code Value is inocreec");
		}
	}

}
