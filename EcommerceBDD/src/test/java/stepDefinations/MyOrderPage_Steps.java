package stepDefinations;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import objectRepository.MyOrderPageObjects;

import pageObjectManagers.PageObjectManager;
import resources.UtilityFunctions;

public class MyOrderPage_Steps extends UtilityFunctions {
	PageObjectManager pageObjectManagerObject;

	Properties propertyObject;
	SoftAssert softAssertObject;
	TestContext testContext;
	MyOrderPageObjects MyOrderPageObject;
	File lastModifiedFile;
	File lastModifiedFile1;
	String lastOrderedItem;

	public MyOrderPage_Steps(TestContext context) throws IOException {
		testContext = context;
		MyOrderPageObject = testContext.getPageObjectManager().getmyOrderPage();
		propertyObject = propertiesFileLoad();
		softAssertObject = softAssertObject();

	}

	@Then("^click on View Order link$")
	public void click_on_view_order_link() throws Throwable {
		MyOrderPageObject.sendObjectViewOrderLink().click();
	}

	@Then("^Verify the ordered item$")
	public void verify_the_ordered_item() throws Throwable {
		softAssertObject.assertEquals(MyOrderPageObject.sendObjectItemOrdered().getText(),
				MyOrderPageObject.sendObjectLastOrderedItem().getText(), "Item ordered and last item does not matches");
	}

	@Then("^click on print order link$")
	public void click_on_print_order_link() throws Throwable {
		lastModifiedFile = getLatestFilefromDir("C:\\Users\\sakgupta1\\Downloads");
		MyOrderPageObject.sendObjectPrintOrderLink().click();
		Thread.sleep(7000L);
		lastModifiedFile1 = getLatestFilefromDir("C:\\Users\\sakgupta1\\Downloads");
	}

	@Then("^click on Reorder button$")
	public void click_on_reorder_button() throws Throwable {
		MyOrderPageObject.sendObjectReorderLink().click();
	}

	@Then("^Verify the product$")
	public void verify_the_product() throws Throwable {
		lastOrderedItem = MyOrderPageObject.sendObjectLastOrderedItem().getText();
		System.out.println("last ordered item" + lastOrderedItem);
		testContext.scenarioContext.setContext(Context.product_Name, lastOrderedItem);
	}

}
