package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends abstractComponents {
	WebDriver driver;
public HomePage(WebDriver driver){
	    super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this );
		}
    
@FindBy (xpath="//div[@class='relative z-400 localisation-form mx-auto']")
WebElement popuploc;	
@FindBy(xpath="//button[@data-testid='close-offer-collection']")
	WebElement closedpopup;
@FindBy(css= "[class=\"button button--secondary text-center\"]")
WebElement startyourOrder;
	//WebElement elemendisplay = 	driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']"));
	@FindBy (xpath = "//input[@placeholder='Enter your location for delivery']")
	WebElement elemendisplay;
	//driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']"));
	@FindBy (xpath = "//input[@placeholder='Enter your location for delivery']")
	WebElement locationproviding;
	//driver.findElement(By.xpath("(//button[@class='text-left pl-15 py-10 border-t border-l-0 border-r-0 border-b-0 border-grey-lightest border-solid suggestion-item'])[1]")).click();
	@FindBy (xpath = "(//button[@class='text-left pl-15 py-10 border-t border-l-0 border-r-0 border-b-0 border-grey-lightest border-solid suggestion-item'])[1]")
	WebElement firstelementfromdorpdown;
	
	public void starttheOrder() {
		startyourOrder.click();
	}
	public void elementToBeDisplay(String loc) {
		elemendisplay.isDisplayed();
		locationproviding.sendKeys(loc);
		
	}
	public ordersPage firstdropDown() {
		firstelementfromdorpdown.click();
		return new ordersPage(driver);

		
	}
	
	public void locationpopup() {
		popuploc.isDisplayed();
	}
	
	public void addressnotfound() {
		closedpopup.click();
	}
	
	public void goTo() {
		driver.get("https://www.pizzahut.co.in/");
	}
	
	













}
