package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import objectRepository.AccountLoginPageObjects;
import objectRepository.UserAccountLoginPageObjects;
import pageObjectManagers.PageObjectManager;
import resources.UtilityFunctions;

public class UserAccountLogin_steps extends UtilityFunctions {
	PageObjectManager pageObjectManagerObject;
	AccountLoginPageObjects AccountLoginPageObject;
	Properties propertyObject;
	SoftAssert softAssertObject;
	TestContext testContext;
	UserAccountLoginPageObjects UserAccountLoginPageObject;

	public UserAccountLogin_steps(TestContext context) throws IOException {
		testContext = context;
		UserAccountLoginPageObject = testContext.getPageObjectManager().getUserAccountLoginPage();
		propertyObject = propertiesFileLoad();
		softAssertObject = softAssertObject();

	}

//	@Then("^On User dashboard page verfiy the user$")
//	public void on_user_dashboard_page_verfiy_the_user() throws Throwable {
//		System.out.println("Inside this");
//		System.out.println(UserAccountLoginPageObject.sendObjectUserEmailId().getText().toString());
//		System.out.println(UserAccountLoginPageObject.sendObjectUserEmailId().getText());
//		System.out.println("agfter this");
//		if (UserAccountLoginPageObject.sendObjectUserEmailId().getText()
//				.contains(propertyObject.getProperty("emailAddress"))) {
//			System.out.println("Inside if blaock");
//		} else {
//			Assert.fail("User is not same");
//		}
//
//	}
	
    @Then("^user click on Mywishlist link$")
    public void user_click_on_mywishlist_link() throws Throwable {
    	UserAccountLoginPageObject.sendObjectMyWishListLink().click();
    }
    
    @Then("^Click on My order link$")
    public void click_on_my_order_link() throws Throwable {
    	UserAccountLoginPageObject.sendObjectMyOrderLink().click();
    }
}
