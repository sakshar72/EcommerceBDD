package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SonyXperiaProductPageObjects {
	WebDriver driverObject;

	public SonyXperiaProductPageObjects(WebDriver driverObject) {
		this.driverObject = driverObject;
		PageFactory.initElements(driverObject, this);

	}

	@FindBy(xpath = "//li[@class='last']")
	WebElement reviewTablink;

	public WebElement sendObjectReviewTablink() {
		return reviewTablink;
	}

	@FindAll(@FindBy(tagName = "a"))
	List<WebElement> allElements;

	public List<WebElement> sendObjectAllAnchorElements() {
		return allElements;
	}
	

	@FindBy(xpath = "//div[@id='customer-reviews']/dl/dt")
	List<WebElement> reviewHeadings;

	public List<WebElement> sendObjectReviewHeadings() {
		return reviewHeadings;
	}
}
