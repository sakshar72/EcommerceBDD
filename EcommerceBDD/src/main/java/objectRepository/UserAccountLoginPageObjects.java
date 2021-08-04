package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserAccountLoginPageObjects {
	WebDriver driverObject;

	public UserAccountLoginPageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//div[@class='col-left sidebar col-left-first']/div[1]/div[2]/ul/li[8]/a")
	WebElement myWishListLink;

	public WebElement sendObjectMyWishListLink() {
		return myWishListLink;
	}

	@FindBy(xpath = "//div[@class='col-left sidebar col-left-first']/div[1]/div[2]/ul/li[4]/a")
	WebElement myOrderLink;

	public WebElement sendObjectMyOrderLink() {
		return myOrderLink;
	}

	@FindBy(xpath = "//a[text()='Reorder']")
	WebElement reOrderLink;

	public WebElement sendObjectReOrderLink() {
		return reOrderLink;
	}

	@FindBy(xpath = "//div[@class='fieldset']/p")
	WebElement wishListEmptyMessage;

	public WebElement sendObjectWishListEmptyMessage() {
		return wishListEmptyMessage;
	}

	@FindBy(xpath = "//div[@class='box-content']/p/br[1]")
	WebElement userEmailId;

	public WebElement sendObjectUserEmailId() {
		return userEmailId;
	}

}
