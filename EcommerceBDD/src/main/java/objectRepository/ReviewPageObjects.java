package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPageObjects {
	WebDriver driverObject;

	public ReviewPageObjects(WebDriver driverObject) {
		this.driverObject = driverObject;
		PageFactory.initElements(driverObject, this);
	}

	@FindBy(xpath = "//textarea[@id='review_field']")
	WebElement reviewField;

	public WebElement sendObjectReviewField() {
		return reviewField;
	}

	@FindBy(xpath = "//input[@id='Quality 1_4']")
	WebElement qualityCheckBox;

	public WebElement sendObjectQualityCheckBox() {
		return qualityCheckBox;
	}

	@FindBy(xpath = "//input[@id='summary_field']")
	WebElement summaryField;

	public WebElement sendObjectSummaryField() {
		return summaryField;
	}

	@FindBy(xpath = "//input[@id='nickname_field']")
	WebElement nickNameField;

	public WebElement sendObjectNicknameField() {
		return nickNameField;
	}

	@FindBy(xpath = "//button[@title='Submit Review']")
	WebElement submitReviewBtn;

	public WebElement sendObjectSubmitReviewBtn() {
		return submitReviewBtn;
	}

	@FindBy(xpath = "//ul[@id='nav']/li[2]")
	WebElement catalogNavLink;

	public WebElement sendObjectCatalogNavLink() {
		return catalogNavLink;
	}

	@FindBy(xpath = "//ul[@id='nav']/li[2]/ul/li")
	WebElement reviewRatingLink;

	public WebElement sendObjectReviewRatingLink() {
		return reviewRatingLink;
	}

	@FindBy(xpath = "//ul[@id='nav']/li[2]/ul/li/ul/li[1]")
	WebElement customerReviewLink;

	public WebElement sendObjectCustomerReviewLink() {
		return customerReviewLink;
	}

	@FindBy(xpath = "//ul[@id='nav']/li[2]/ul/li/ul/li[1]/ul/li[1]")
	WebElement reviewPendingLink;

	public WebElement sendObjectReviewPendingLink() {
		return reviewPendingLink;
	}

	@FindBy(xpath = "//div[@id='advice-validate-rating-validate_rating']")
	WebElement qualityCheckboxError;

	public WebElement sendObjectQualityCheckboxError() {
		return qualityCheckboxError;
	}

	@FindBy(xpath = "//div[@id='advice-required-entry-review_field']")
	WebElement reviewFieldError;

	public WebElement sendObjectReviewFieldError() {
		return reviewFieldError;
	}

	@FindBy(xpath = "//div[@id='advice-required-entry-summary_field']")
	WebElement summaryFieldError;

	public WebElement sendObjectSummaryFieldError() {
		return summaryFieldError;
	}

	@FindBy(xpath = "//div[@id='advice-required-entry-nickname_field']")
	WebElement nickNameFieldError;

	public WebElement sendObjectNickNameFieldError() {
		return nickNameFieldError;
	}
	
	@FindBy(xpath = "//li[@class='success-msg']/ul/li/span")
	WebElement reviewSuccessMessage;

	public WebElement sendObjectReviewSuccessMessage() {
		return reviewSuccessMessage;
	}
}
