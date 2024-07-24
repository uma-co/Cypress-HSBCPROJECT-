package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class Homepage extends abstractComp {
		WebDriver driver;
	public Homepage(WebDriver driver){
		    super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this );
			}
//	  driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("Laptop", Keys.ENTER);  
	@FindBy (xpath="//input[@title='Search for Products, Brands and More']")
	WebElement searchLap;	
//	  WebElement label = driver.findElement(By.xpath("//span[@class='BUOuZu']"));
	@FindBy(xpath="//span[@class='BUOuZu']")
		WebElement searchedLap;
//	List<WebElement> title = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
//	System.out.println(title.size());
	@FindBy(xpath= "//div[@class='KzDlHZ']")
	WebElement Title;
	

	
public void searchbox(String value) {
	
	searchLap.sendKeys(value, Keys.ENTER);
	
}

public void searchedValuepresentinsearch(String value) {
	System.out.println(searchedLap.getText().contains(value));
}
public productsPage getTitleproductspage()
{
	driver.getTitle();
	return new productsPage(driver);
}

public void goTo() {
	// TODO Auto-generated method stub
	driver.get("https://www.flipkart.com/");
}
	
	
}

