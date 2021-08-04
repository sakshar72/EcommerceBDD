package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPageObjects {
	WebDriver driverObject;

	public CreateAccountPageObjects(WebDriver driverObj) {
		this.driverObject = driverObj;
		PageFactory.initElements(driverObj, this);
	}

	@FindBy(xpath = "//input[@id='firstname']")
	WebElement firstName;

	public WebElement sendObjectFirstName() {
		return firstName;
	}

	@FindBy(xpath = "//input[@id='middlename']")
	WebElement middleName;

	public WebElement sendObjectMiddleName() {
		return middleName;
	}

	@FindBy(xpath = "//input[@id='lastname']")
	WebElement lastName;

	public WebElement sendObjectLastName() {
		return lastName;
	}

	@FindBy(xpath = "//input[@id='email_address']")
	WebElement emailAddress;

	public WebElement sendObjectEmailAddress() {
		return emailAddress;
	}

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	public WebElement sendObjectpassword() {
		return password;
	}

	@FindBy(xpath = "//input[@id='confirmation']")
	WebElement confirmPassword;

	public WebElement sendObjectConfirmPassword() {
		return confirmPassword;
	}

	@FindBy(xpath = "//button[@title='Register']")
	WebElement registerBtn;

	public WebElement sendObjectRegisterBtn() {
		return registerBtn;
	}

	@FindBy(xpath = "//li[@class='error-msg']/ul/li/span")
	WebElement loginFailedErrorMessage;

	public WebElement sendObjectLoginFailedErrorMessage() {
		return loginFailedErrorMessage;
	}

	@FindBy(xpath = "//li[@class='success-msg']/ul/li/span")
	WebElement AccountCreatedMessage;

	public WebElement sendObjectAccountCreatedMessage() {
		return AccountCreatedMessage;
	}

	@FindBy(xpath = "//a[text()='TV']")
	WebElement tvNavLink;

	public WebElement sendObjectTvNavLink() {
		return tvNavLink;
	}

	@FindBy(xpath = "//div[@class='col2-set']/div[1]/div[1]/div[2]/p")
	WebElement userFields;

	public WebElement sendObjectUserFields() {
		return userFields;
	}

	@FindBy(xpath = "//div[@id='advice-required-entry-email_address']")
	WebElement emailMandatoryFieldError;

	public WebElement sendObjectEmailMandatoryFieldError() {
		return emailMandatoryFieldError;
	}

	@FindBy(xpath = "//div[@id='advice-validate-cpassword-confirmation']")
	WebElement passwordMismatchFieldError;

	public WebElement sendObjectPasswordMismatchFieldError() {
		return passwordMismatchFieldError;
	}

	@FindBy(xpath = "//div[@id='advice-required-entry-firstname']")
	WebElement usernameRequiredFieldError;

	public WebElement sendObjectUsernameRequiredFieldError() {
		return usernameRequiredFieldError;
	}

	@FindBy(xpath = "//div[@id='advice-required-entry-lastname']")
	WebElement lastNameRequiredFieldError;

	public WebElement sendObjectLastNameRequiredFieldError() {
		return lastNameRequiredFieldError;
	}

	@FindBy(xpath = "//div[@id='advice-required-entry-password']")
	WebElement passwordRequiredFieldError;

	public WebElement sendObjectPasswordRequiredFieldError() {
		return passwordRequiredFieldError;
	}

	@FindBy(xpath = "//div[@id='advice-required-entry-confirmation']")
	WebElement confirmPasswordRequiredFieldError;

	public WebElement sendObjectConfirmPasswordRequiredFieldError() {
		return confirmPasswordRequiredFieldError;
	}
}
