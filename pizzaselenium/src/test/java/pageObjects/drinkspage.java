package pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class drinkspage extends abstractComponents{

	WebDriver driver;
	public drinkspage(WebDriver driver) {
	    super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this );
	}
	//WebElement drinklink = driver.findElement(By.xpath("(//a[@href='/order/drinks/'])[2]"));
   // drinklink.click();
	
//	List<WebElement> Totaldrinks = driver.findElements(By.xpath("//div[@class='typography-4 list-item__name flex-1 px-10 pt-10']"
	
	@FindBy(xpath=("(//a[@href='/order/drinks/'])[2]"))
	WebElement drinksMenuLink;
	@FindBy(xpath=("//div[@class='typography-4 list-item__name flex-1 px-10 pt-10']"))
	List<WebElement> TotalDrinks;
	//List<WebElement> drinksAddButton = driver.findElements(By.xpath("//div[@class='m-10']//button[@class='button button--md button--green flex-1 font-semibold']"));
	@FindBy(xpath=("//div[@class='m-10']//button[@class='button button--md button--green flex-1 font-semibold']"))
	WebElement drinksAddButton;
	
	public void drinkmenuLInk() {
		drinksMenuLink.click();
	}
	
	public checkoutPage drinksSelection() throws InterruptedException {
		 for(int j = 1 ; j<TotalDrinks.size() ; j++ ) {
			 
		 
			 String[] drinks = {"Pepsi Zero Sugar","7UP","Mirinda"};
		    	String formatteddrinks = TotalDrinks.get(j).getText().split("-")[0].trim();
		    	System.out.println(formatteddrinks);
		    	List L = Arrays.asList(drinks);
		    	System.out.println(L);
		    	
		    	if(L.contains(formatteddrinks)) {
		    		Thread.sleep(3000);
		    		scrollDown();
		    	driver.findElement(By.xpath("(//div[@class='m-10']//button[@class='button button--md button--green flex-1 font-semibold'])["+j+"]")).click();
		    		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button button--md button--green flex-1 font-semibold']//span[contains(text(),'Add')]"))).click();
	          
		    	
		    	}}
		 return new checkoutPage(driver);
		 
	
	
	
	
	
	
	
	

	}}
