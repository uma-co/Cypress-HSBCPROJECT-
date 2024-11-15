package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.reusablecomp;

public class HomePage extends reusablecomp{
	public WebDriver driver;
	public HomePage(WebDriver driver){
		super(driver);
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
}
	@FindBy(css=".bl-input-create")
	WebElement contact_Num;
	@FindBy(xpath="//button[text()='Send OTP']")
	WebElement otpButton;
	@FindBy(xpath="(//span[text()='Locked Message'])[1]")
	WebElement locked_Message;
	@FindBy(xpath="//button[text()='Verify OTP']")
	WebElement verify_OTP;
	public void verifyOtp() {
		verify_OTP.click();
	}
	
	public void login_contactnum() {
		contact_Num.sendKeys("9080327791");
	}
	public void sendOtp() {
		otpButton.click();
	}
	public HomePage locked_message() {
		locked_Message.click();
		return null;
	}
}

