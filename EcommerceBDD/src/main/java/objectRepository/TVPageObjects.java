package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TVPageObjects {
	WebDriver driverObject;

	public TVPageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//li[@class='item last'][1]/div/div[@class='actions']/ul/li[1]")
	WebElement addToWishlistBtn;

	public WebElement sendObjectAddToWishlistBtn() {
		return addToWishlistBtn;
	}

	@FindBy(xpath = "//ul[@class='products-grid products-grid--max-4-col first last odd']/li[1]/div/h2/a")
	WebElement tvProduct;

	public String sendObjectTVProduct() {
		return tvProduct.getText();
	}

	@FindBy(xpath = "//ul[@class='products-grid products-grid--max-4-col first last odd']/li[1]/div/div[1]/p[2]/span[2]")
	WebElement tvPrice;

	public String sendObjectTVPrice() {
		return tvPrice.getText();
	}
}
