package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends abstractComponents{
 WebDriver driver;
	public Homepage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this );
		}
	
	// WebElement entering_loc = driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']"));
	 //entering_loc.sendKeys("Lulu Mall, Bangalore");
	@FindBy(xpath=("//input[@placeholder='Enter your location for delivery']"))
	WebElement entering_location;
//	 WebElement dropdown = driver.findElement(By.xpath("(//button[@class='text-left pl-15 py-10 border-t border-l-0 border-r-0 border-b-0 border-grey-lightest border-solid suggestion-item'])[1]"));
    @FindBy(xpath=("(//button[@class='text-left pl-15 py-10 border-t border-l-0 border-r-0 border-b-0 border-grey-lightest border-solid suggestion-item'])[1]"))
	WebElement dropdown;
    
    public void enteringLoc() {
    	entering_location.sendKeys("Lulu Mall, hyd");
    }
    
    public void dropdownselection() {
    	dropdown.click();
    }
    public void goT() {
    	driver.get("https://www.pizzahut.co.in/");
    }
    
    public pizzapage dealsUrl() {
    	String url = driver.getCurrentUrl();
        if(url.contains("deals")) {
       	 System.out.println("user is on deals page");
        }
        scrollUp();
        return new pizzapage(driver);
        
    }




















}
