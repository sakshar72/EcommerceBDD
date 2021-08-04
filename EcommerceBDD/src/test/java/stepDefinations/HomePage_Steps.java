package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.testng.asserts.SoftAssert;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectRepository.HomePageObjects;
import pageObjectManagers.PageObjectManager;
import resources.UtilityFunctions;

public class HomePage_Steps extends UtilityFunctions {
	PageObjectManager pageObjectManagerObject;
	HomePageObjects homePageObject;
	Properties propertyObject;
	SoftAssert softAssertObject;
	TestContext testContext;

	public HomePage_Steps(TestContext context) throws IOException {
		testContext = context;
		homePageObject = testContext.getPageObjectManager().getHomePage();
		propertyObject = propertiesFileLoad();
		softAssertObject = softAssertObject();
	}

	@Given("^User Open the Home Page URL$")
	public void user_Open_the_Hpme_Page_URL() throws Throwable {
		driverObject.get(propertyObject.getProperty("homePageURL"));
		driverObject.manage().window().maximize();
//		pageObjectManagerObject = new PageObjectManager(driverObject);
//		homePageObject = pageObjectManagerObject.getHomePage();
	}

	@Then("^Verfiy the Title of the Page$")
	public void verfiy_the_Title_of_the_Page() throws Throwable {
		softAssertObject.assertEquals(driverObject.getTitle(), propertyObject.getProperty("homePageTitle"));
		softAssertObject.assertAll();
	}

	@When("^User click on Mobile Button$")
	public void user_click_on_Mobile_Button() throws Throwable {
		System.out.println("dsdsd" + homePageObject);
		// Write code here that turns the phrase above into concrete actions
		homePageObject.sendObjectMobileNavButton().click();
	}

	@When("^User click on my account link$")
	public void user_click_on_my_account_link() throws Throwable {
		homePageObject.sendObjectMyAccountLink().click();
	}

	@Given("^Open the review page url$")
	public void open_the_review_page_url() throws Throwable {
		driverObject.get(propertyObject.getProperty("reviewPageURL"));
		driverObject.manage().window().maximize();
	}

	@Then("^user click on Advanced Search$")
	public void user_click_on_advanced_search() throws Throwable {
		homePageObject.sendObjectAdvancedSearch().click();
	}

}
