package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobilePageObjects {
	WebDriver driverObject;

	public MobilePageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//div[@class='col-wrapper']/div[1]/div[3]/div[1]/div[1]/div/select")
	WebElement sortByDropdown;

	@FindBy(xpath = "//a[@title='Site Map']")
	WebElement linkText;

	@FindBy(xpath = "//span[@id='product-price-1']/span")
	WebElement productPrice;

	@FindBy(xpath = "//div[@class='category-products']/ul/li[1]/div/h2/a")
	WebElement productName;

	@FindBy(xpath = "//li[@class='item last'][1]/div/div[@class='actions']/ul/li[2]")
	WebElement xperiaAddToCompareBtn;

	@FindBy(xpath = "//span[@id='product-price-1']/span")
	WebElement xperiaProductPrice;

	@FindBy(xpath = "//button[@title='Add to Cart']")
	WebElement addToCart;

	@FindBy(xpath = "//li[@class='item last'][2]/div/div[@class='actions']/ul/li[2]")
	WebElement iphoneAddToCompareBtn;

	@FindBy(xpath = "//button[@title='Compare']")
	WebElement compareBtn;

	@FindBy(xpath = "//div[@class='block-content']/ol/li[1]/p/a")
	WebElement firstProductName;

	@FindBy(xpath = "//div[@class='block-content']/ol/li[2]/p/a")
	WebElement secondProductName;

	@FindBy(xpath = "//ol[@id='compare-items']/li")
	public List<WebElement> selects;

	public List<WebElement> sendObjectNumberOfItems() {
		return selects;
	}

	@FindBy(xpath = "//ol[@id='compare-items']/li/p")
	public List<WebElement> headingOfItemToCompare;

	public List<WebElement> sendObjectHeadingOfItemToCompare() {
		return headingOfItemToCompare;
	}

	@FindBy(xpath = "//ul[@class='products-grid products-grid--max-4-col first last odd']/li/div/h2/a")
	public List<WebElement> productHeading;

	public List<WebElement> sendObjectProductHeading() {
		return productHeading;
	}

	@FindBy(xpath = "//table[@id='product_comparison']/tbody[1]/tr/td/h2/a")
	public List<WebElement> popupProductNeading;

	public List<WebElement> sendObjectPopupProductNeading() {
		return popupProductNeading;
	}

	public WebElement sendObjectFirstProductName() {
		return firstProductName;
	}

	@FindBy(xpath = "//img[@id='product-collection-image-1']")
	WebElement sonyXperiaSelectProduct;

	public WebElement sendObjectSonyXperiaSelectProduct() {
		return sonyXperiaSelectProduct;
	}

	public WebElement sendObjectXperiaProductPrice() {
		return xperiaProductPrice;
	}

	public WebElement sendObjectAddToCart() {
		return addToCart;
	}

	public WebElement sendObjectSecondProductName() {
		return secondProductName;
	}

	public WebElement sendObjectCompareBtn() {
		return compareBtn;
	}

	public WebElement sendObjectXperiaAddToCompareBtn() {
		return xperiaAddToCompareBtn;
	}

	public WebElement sendObjectIphoneAddToCompareBtn() {
		return iphoneAddToCompareBtn;
	}

	public WebElement sendObjectSortByDropdown() {
		return sortByDropdown;
	}

	public WebElement sendObjectLinkText() {
		return linkText;
	}

	public WebElement sendProductPrice() {
		return productPrice;
	}

	public WebElement sendObjectProductName() {
		return productName;
	}

	@FindBy(xpath = "//li[@class='item last'][2]/div/div[@class='actions']/button")
	WebElement iphoneAddToCart;

	public WebElement sendObjectIphoneAddToCart() {
		return iphoneAddToCart;
	}

	@FindBy(xpath = "//ul[@class='products-grid products-grid--max-4-col first last odd']/li[1]/div/h2/a")
	WebElement sonyXperiaProductName;

	public WebElement sendObjectSonyXperiaProductName() {
		return sonyXperiaProductName;
	}

}
