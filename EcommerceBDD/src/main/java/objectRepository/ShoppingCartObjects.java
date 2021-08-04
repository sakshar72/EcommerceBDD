package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartObjects {
	WebDriver driver;

	public ShoppingCartObjects(WebDriver driverObject) {
		this.driver = driverObject;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[@class='product-cart-actions']/input")
	WebElement productQuantityInputField;

	public WebElement sendObjectProductQuantityInputField() {
		return productQuantityInputField;
	}

	@FindBy(xpath = "//button[@title='Update']")
	WebElement productQuantityUpdateBtn;

	public WebElement sendObjectProductQuantityUpdateBtn() {
		return productQuantityUpdateBtn;
	}

	@FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr/td[2]/p")
	WebElement productLimitErrorMessage;

	public WebElement sendObjectProductLimitErrorMessage() {
		return productLimitErrorMessage;
	}

	@FindBy(xpath = "//button[@id='empty_cart_button']")
	WebElement emptyCartBtn;

	public WebElement sendObjectEmptyCartBtn() {
		return emptyCartBtn;
	}

	@FindBy(xpath = "//div[@class='page-title']/h1")
	WebElement emptyCartMessage;

	public WebElement sendObjectEmptyCartMessage() {
		return emptyCartMessage;
	}

	@FindBy(xpath = "//button[@title='Proceed to Checkout']")
	WebElement checkoutBtn;

	public WebElement sendObjectCheckoutBtn() {
		return checkoutBtn;
	}

	@FindBy(xpath = "//input[@title='Qty']")
	WebElement quantityInputField;

	public WebElement sendObjectQuantityInputField() {
		return quantityInputField;
	}

	@FindBy(xpath = "//button[@title='Update']")
	WebElement updateBtn;

	public WebElement sendObjectUpdateBtn() {
		return updateBtn;
	}

	@FindBy(xpath = "//table[@id='shopping-cart-totals-table']/tfoot/tr/td[2]")
	WebElement totalCost;

	public WebElement sendObjectTotalCost() {
		return totalCost;
	}

	@FindBy(xpath = "//li[@class='method-checkout-cart-methods-onepage-bottom']/button[@title='Proceed to Checkout']")
	WebElement proceedToCheckoutBtn;

	public WebElement sendObjectProceedToCheckoutBtn() {
		return proceedToCheckoutBtn;
	}

	@FindBy(xpath = "//li[@class='success-msg']/ul/li/span")
	WebElement productAddedSuccessMessage;

	public WebElement sendObjectProductAddedSuccessMessage() {
		return productAddedSuccessMessage;
	}

	@FindBy(xpath = "//li[@class='error-msg']/ul/li/span")
	WebElement quantityErrorMessage;

	public WebElement sendObjectQuantityErrorMessage() {
		return quantityErrorMessage;
	}

	@FindBy(xpath = "//td[@class='product-cart-total']/span/span")
	WebElement productPrice;

	public WebElement sendObjectproductPrice() {
		return productPrice;
	}

	@FindBy(xpath = "//table[@id='shopping-cart-table']/tbody/tr/td[2]/h2/a")
	WebElement productName;

	public WebElement sendObjectProductName() {
		return productName;
	}

}
