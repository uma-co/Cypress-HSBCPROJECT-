package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class checkoutPage extends abstractComponents{
WebDriver driver;
	public checkoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this );
	}
	//WebElement checkout = driver.findElement(By.xpath("(//span[@class='absolute inset-0 flex-center'])[2]"));
	//checkout.click();
	@FindBy(xpath=("(//span[@class='absolute inset-0 flex-center'])[2]"))
	WebElement CheckOutButton;
	//Validate that the Online Payment radio button is selected by default
	@FindBy(xpath=("//label[@class='flex border py-20 px-10 rounded mb-10 border border-green border-solid']//i[1]"))
	WebElement onlinePaymentRadioButton;
	//Change the Payment option to Cash
	@FindBy(xpath=("//label[@class='flex border py-20 px-10 rounded mb-10 items-center']//i[1]"))
	WebElement cashOption;
    //Validate that the I agree checkbox is checked by default
	@FindBy(xpath=("//span[contains(text(),'I agree to receive promotional communication.')]"))
	WebElement checkoutOption;
	//Enter name
	@FindBy(id=("checkout__name"))
	WebElement name;
	//ENTER A PHONE NUMBER
	@FindBy(id=("checkout__phone"))
	WebElement Number;
	//enter a email
    @FindBy(id =("checkout__email"))
    WebElement email;
	//Click on the Apply Gift Card link
	@FindBy(css=("[class='sc-fzqMdD eohbfP']"))
	WebElement giftCrd;
    //A pop up should appear. Click on the Voucher
    @FindBy(css=("[class='sc-fzoant smfTD p-10 pt-20 bg-white m-20 rounded shadow relative']"))
    WebElement voucher;
    //Give the Voucher code as 12345 and submit
    @FindBy(css=("[class='sc-fznMnq gdZumo']"))
    WebElement coupon;
    @FindBy(name=("voucherId"))
    WebElement voucherCode;
   @FindBy(css=("[type='submit']"))
   WebElement applyButton;
    //Validate if an error is coming that the number is incorrect
    @FindBy(xpath=("//div[@class='sc-fznJRM ciBEcK']//span"))
    WebElement TextMessage;
    //Assert.assertEquals(ErrorMessage, "Sorry, we don’t currently support that coupon code.");
    
    public void checkoutbutton() {
    	CheckOutButton.click();
    }
    
    public void radiobutton() {
    	onlinePaymentRadioButton.isSelected();
    }
    public void casbutton() {
    	cashOption.click();
    }
    public void checkbox() {
    	checkoutOption.click();
    }
    public void Details() {
    	name.sendKeys("uma");
    	Number.sendKeys("9080327791");
    	email.sendKeys("umaraaj68489@gmail.com");
    }
    public void voucherTab() {
    	giftCrd.click();
    }
    public void voucher() {
    	voucher.isDisplayed();
    	coupon.click();
    	voucherCode.sendKeys("12345");
    	applyButton.click();
    }
    public String ErrorMessage() {
    	return TextMessage.getText();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
