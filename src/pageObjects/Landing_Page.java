package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.reusablecomp;

public class Landing_Page extends reusablecomp {

	public WebDriver driver;
	public Landing_Page(WebDriver driver){
		super(driver);
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
}
	
	@FindBy(css=".fe.fe-eye")
	List<WebElement> reader;
	@FindBy(xpath="(//div[@class='col-md-auto'])[3]")
	WebElement createlocked_message;
	@FindBy(css="[placeholder='Amount']")
	WebElement amount;
	@FindBy(css="[name='visibleMessage']")
	WebElement visibleText;
	@FindBy(id="bigButton")
	WebElement Next_Button;
	@FindBy(css=".fe.fe-eye")
	WebElement read;
	@FindBy(xpath="(//button[@class='btn btn-link']//i[@class='fe fe-eye'])[2]")
	List<WebElement> readviews;
	@FindBy(css="[placeholder='Premium Content']")
	WebElement Premium_content;
	@FindBy(id="bigButton")
	WebElement submitButton;
	@FindBy(css=".fe.fe-eye")
	List<WebElement> read_lockedmessage;
	@FindBy(css=".fe.fe-edit")
List<WebElement> edit_locked_message;
	
	public void read_mess() {
		reader.get(1).click();
	}
	
	
	
	public void edit_locked_message() {
		edit_locked_message.get(1).click();
	}
	
	public void read_locked_message() {
		read_lockedmessage.get(1).click();
	}
	
	
	public void submit() {
		submitButton.click();
	}
	
	public void premium_content() {
		Premium_content.sendKeys("kello");
	}
	public void multilineItems() {
		for(int i = 1 ; i<= readviews.size(); i++) {
			readviews.get(i).click();
		}
	}
	
	public void readView() {
		read.click();
	}
	
	public void nextButton() {
		Next_Button.click();
	}
	public void createLockMessage() {
		createlocked_message.click();
	}
	public void clear_amount() {
		amount.clear();
	}
	public void enterAmount(String value) {
		amount.sendKeys(value);
	}
	public void visibleMessages(String visiblevalue) {
		visibleText.sendKeys(visiblevalue);
	}
}

