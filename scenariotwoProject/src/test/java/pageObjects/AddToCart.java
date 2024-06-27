package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_Com.Abstract_class;

public class AddToCart extends Abstract_class {

	
		WebDriver driver;
	public AddToCart(WebDriver driver){
		    super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this );
			}
	    
	@FindBy (id="essenceCartBtn")
	WebElement addToCart;	
	@FindBy(xpath="(//a[@href='checkout.html'])[2]")
		WebElement checkout;
	@FindBy(id="first_name")
	WebElement first_name;
	@FindBy(id="last_name")
	WebElement last_name;
	@FindBy(css=".nice-select.w-100.open")
	WebElement dropdown;
	@FindBy(css="[class'option']")
	List<WebElement> dropdownlist;
	@FindBy(id="postcode")
	 WebElement postcode;
	@FindBy(id="city")
	 WebElement city;
	@FindBy(id="state")
	 WebElement state;
	@FindBy(id="phone_number")
	 WebElement phone_number;
	@FindBy(id="email_address")
	 WebElement email_address;
	@FindBy(xpath="(//a[@class='btn essence-btn'])[2]")
	 WebElement place_order;
	@FindBy(xpath="(//div[@class='nicescroll-cursors'])[3]")
	WebElement nestedScroll;
	public void addTocart() {
		addToCart.click();
	}
	
	public void checkout() {
		checkout.click();
	}
	public void billingAddress() {
		first_name.sendKeys("uma");
		last_name.sendKeys("R");
		dropdown.click();
	}
	public void listofDropdowns() {
		int i = 0;
		if(dropdownlist.get(i).getText().contains("india")) {
			dropdownlist.get(i).click();
		}
	}
	public void textBoxes() {
		postcode.sendKeys("608001");
		city.sendKeys("chidambaram");
		state.sendKeys("tn");
		phone_number.sendKeys("9080327791");
		email_address.sendKeys("umaraah@gmail.com");
	}
	public void placeOrder() {
	place_order.click();
	}
}
	
	
	
