package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvanceSearchPageObjects {
	WebDriver driverObject;

	public AdvanceSearchPageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//input[@id='price']")
	WebElement priceInputField;

	public WebElement sendObjectPriceInputField() {
		return priceInputField;
	}

	@FindBy(xpath = "//input[@id='price_to']")
	WebElement priceToInputField;

	public WebElement sendObjectPriceToInputField() {
		return priceToInputField;
	}

	@FindBy(xpath = "//li[@class='error-msg']/ul/li/span")
	WebElement searchFieldErrorMessage;

	public WebElement sendObjectSearchFieldErrorMessage() {
		return searchFieldErrorMessage;
	}

	@FindBy(xpath = "//p[@class='error-msg']")
	WebElement modifySearchErrorMessage;

	public WebElement sendObjectModifySearchErrorMessage() {
		return modifySearchErrorMessage;
	}

	@FindBy(xpath = "//span[@id='product-price-3']")
	WebElement secondProductPrice;

	public WebElement sendObjectSecondProductPrice() {
		return secondProductPrice;
	}

	@FindBy(xpath = "//span[@id='product-price-1']")
	WebElement firstProductPrice;

	public WebElement sendObjectFirstProductPrice() {
		return firstProductPrice;
	}

	@FindBy(xpath = "//div[@class = 'buttons-set']/button")
	WebElement searchButton;

	public WebElement sendObjectSearchButton() {
		return searchButton;
	}
}
