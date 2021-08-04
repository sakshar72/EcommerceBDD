package pageObjectManagers;

import org.openqa.selenium.WebDriver;

import objectRepository.AccountLoginPageObjects;
import objectRepository.AdvanceSearchPageObjects;
import objectRepository.BackendPageObjects;
import objectRepository.CheckoutPageObjects;
import objectRepository.CreateAccountPageObjects;
import objectRepository.HomePageObjects;
import objectRepository.MobilePageObjects;
import objectRepository.MyOrderPageObjects;
import objectRepository.ReviewPageObjects;
import objectRepository.ShoppingCartObjects;
import objectRepository.SonyXperiaProductPageObjects;
import objectRepository.TVPageObjects;
import objectRepository.UserAccountLoginPageObjects;
import objectRepository.WishlistPageObjects;

public class PageObjectManager {
	WebDriver driver;

	HomePageObjects homePageObject;
	MobilePageObjects MobilePageObject;
	ShoppingCartObjects ShoppingCartObject;
	AccountLoginPageObjects AccountLoginPageObject;
	CreateAccountPageObjects CreateAccountPageObject;
	TVPageObjects TVPageObject;
	WishlistPageObjects WishlistPageObject;
	UserAccountLoginPageObjects UserAccountLoginPageObject;
	CheckoutPageObjects CheckoutPageObject;
	MyOrderPageObjects MyOrderPageObject;
	ReviewPageObjects ReviewPageObject;
	BackendPageObjects BackendPageObject;
	SonyXperiaProductPageObjects SonyXperiaProductPageObject;
	AdvanceSearchPageObjects AdvanceSearchPageObject;

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public HomePageObjects getHomePage() {

		return (homePageObject == null) ? homePageObject = new HomePageObjects(driver) : homePageObject;

	}

	public MobilePageObjects getMobilePage() {

		return (MobilePageObject == null) ? MobilePageObject = new MobilePageObjects(driver) : MobilePageObject;

	}

	public ShoppingCartObjects getShoppingCartPage() {

		return (ShoppingCartObject == null) ? ShoppingCartObject = new ShoppingCartObjects(driver) : ShoppingCartObject;

	}

	public AccountLoginPageObjects getAccountLoginPage() {

		return (AccountLoginPageObject == null) ? AccountLoginPageObject = new AccountLoginPageObjects(driver)
				: AccountLoginPageObject;

	}

	public CreateAccountPageObjects getCreateAccountLoginPage() {

		return (CreateAccountPageObject == null) ? CreateAccountPageObject = new CreateAccountPageObjects(driver)
				: CreateAccountPageObject;

	}

	public TVPageObjects getTVPage() {

		return (TVPageObject == null) ? TVPageObject = new TVPageObjects(driver) : TVPageObject;

	}

	public WishlistPageObjects getWishListPage() {

		return (WishlistPageObject == null) ? WishlistPageObject = new WishlistPageObjects(driver) : WishlistPageObject;

	}

	public UserAccountLoginPageObjects getUserAccountLoginPage() {

		return (UserAccountLoginPageObject == null)
				? UserAccountLoginPageObject = new UserAccountLoginPageObjects(driver)
				: UserAccountLoginPageObject;

	}

	public CheckoutPageObjects getCheckoutPage() {

		return (CheckoutPageObject == null) ? CheckoutPageObject = new CheckoutPageObjects(driver) : CheckoutPageObject;

	}

	public MyOrderPageObjects getmyOrderPage() {

		return (MyOrderPageObject == null) ? MyOrderPageObject = new MyOrderPageObjects(driver) : MyOrderPageObject;

	}
	
	public ReviewPageObjects getProductReviewPage() {

		return (ReviewPageObject == null) ? ReviewPageObject = new ReviewPageObjects(driver) : ReviewPageObject;

	}
	
	public BackendPageObjects getbackendPage() {

		return (BackendPageObject == null) ? BackendPageObject = new BackendPageObjects(driver) : BackendPageObject;

	}
	
	public SonyXperiaProductPageObjects getSonyXperiaPage() {

		return (SonyXperiaProductPageObject == null) ? SonyXperiaProductPageObject = new SonyXperiaProductPageObjects(driver) : SonyXperiaProductPageObject;

	}
	
	public AdvanceSearchPageObjects getAdvancedSearchPage() {

		return (AdvanceSearchPageObject == null) ? AdvanceSearchPageObject = new AdvanceSearchPageObjects(driver) : AdvanceSearchPageObject;

	}

}
