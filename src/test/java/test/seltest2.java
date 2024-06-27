package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


import pageObjects.Homepage;

public class seltest2 {
@Test
public void standalone() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "/home/umaraaj1999gmai/Downloads/chromedriver");
	
	 WebDriver driver = new ChromeDriver();
	 driver.get("https://www.pizzahut.co.in/");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    JavascriptExecutor js = ( JavascriptExecutor)driver;
	    
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 
	 //Then, set the user delivery location as Lulu Mall, Bangalore
	 
	 WebElement entering_loc = driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']"));
	 entering_loc.sendKeys("Lulu Mall, Bangalore");
//	 driver.findElement(By.xpath("//button[@class='icon-close--white p-30 absolute top-0 right-0 mr-10 mt-10']")).click();
	 
     WebElement dropdown = driver.findElement(By.xpath("(//button[@class='text-left pl-15 py-10 border-t border-l-0 border-r-0 border-b-0 border-grey-lightest border-solid suggestion-item'])[1]"));
     dropdown.click();
     Thread.sleep(10000);
     driver.findElement(By.xpath("//button[@class='icon-close--white p-30 absolute top-0 right-0 mr-10 mt-10']")).click();
     dropdown.click();
     // hp.dropdownselection();
//     Thread.sleep(5000);
//     WebElement addressnotfound = driver.findElement(By.cssSelector("[data-testid=\"close-offer-collection\"]"));
//     wait.until(ExpectedConditions.visibilityOf(addressnotfound));
//     
//    addressnotfound.click();
     //deals
     
     String url = driver.getCurrentUrl();
     if(url.contains("deals")) {
    	 System.out.println("user is on deals page");
     }
     //Go to sides and add any item that is below 200
     WebElement sideslink = driver.findElement(By.xpath("(//a[@href='/order/sides/'])[2]"));
     sideslink.click();
     //order any time
     List<WebElement> listofsides= driver.findElements(By.xpath("//div[contains(text(),'BBQ Baked Chicken Wings 6 Pcs')]"));
     List<WebElement> AddButton = driver.findElements(By.xpath("//button[@class='button button--md button--green flex-1 font-semibold']"));
     int sidesize = listofsides.size();
     for(int i=0; i<sidesize; i++) {
	if(listofsides.get(i).getText().contains("BBQ Baked Chicken Wings 6 Pcs")) {
		System.out.println(listofsides.get(i).getText());
		//driver.findElement(By.xpath("(//button[@class='button button--md button--green flex-1 font-semibold'])["+i+"]")).click();
		AddButton.get(i).click();
	}
   }
     //Validate that the product is added under Basket but checkout button price item is still now
     //showing
    WebElement basket=  driver.findElement(By.cssSelector("[data-synth='basket-item-type--side']"));
    if(basket.getText().contains("Cheezy Sprinkled Fries")) {
    	System.out.println(basket.getText() + " is added in the basket");
    	    }
    //Navigate to the Drinks page
  js.executeScript("window.scrollBy(0,-250)");
    WebElement drinklink = driver.findElement(By.xpath("(//a[@href='/order/drinks/'])[2]"));
    drinklink.click();
    String[] drinks = {"Pepsi Zero Sugar","7UP","Mirinda"};
    
    // Pepsi - 475ml // Pepsi Zero Sugar - 300ml //Mirinda - 475ml
    List<WebElement> Totaldrinks = driver.findElements(By.xpath("//div[@class='typography-4 list-item__name flex-1 px-10 pt-10']"));
   List<WebElement> drinksAddButton = driver.findElements(By.xpath("//div[@class='m-10']//button[@class='button button--md button--green flex-1 font-semibold']"));
  System.out.println(Totaldrinks.size());
   //List<WebElement> drinksAddButton = driver.findElements(By.xpath("//button[@class='button button--md button--green flex-1 font-semibold']//span[contains(text(),'Add')]"));
    for(int j = 1 ; j<Totaldrinks.size() ; j++ ) {
    	String formatteddrinks = Totaldrinks.get(j).getText().split("-")[0].trim();
    	System.out.println(formatteddrinks);
    	List L = Arrays.asList(drinks);
    	System.out.println(L);
    	
    	if(L.contains(formatteddrinks)) {
    		Thread.sleep(3000);
    		js.executeScript("window.scrollBy(0,270)");
    	driver.findElement(By.xpath("(//div[@class='m-10']//button[@class='button button--md button--green flex-1 font-semibold'])["+j+"]")).click();
    		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button button--md button--green flex-1 font-semibold']//span[contains(text(),'Add')]"))).click();
    		//driver.findElements(By.xpath("//button[@class='button button--md button--green flex-1 font-semibold']//span[contains(text(),'Add')]")).get(j).click();
    		//driver.findElement(By.cssSelector("[data-synth='button--mirinda-600ml--one-tap']")).click();
    		//drinksAddButton.get(j).click();
    		
    	}
    }
    	//Click on the Checkout button. The user will be navigated to the checkout page
    	WebElement checkout = driver.findElement(By.xpath("(//span[@class='absolute inset-0 flex-center'])[2]"));
    	checkout.click();
    	//Validate that the Online Payment radio button is selected by default
    	driver.findElement(By.xpath("//label[@class='flex border py-20 px-10 rounded mb-10 border border-green border-solid']//i[1]")).isSelected();
    	//Change the Payment option to Cash
    	driver.findElement(By.xpath("//label[@class='flex border py-20 px-10 rounded mb-10 items-center']//i[1]")).click();
        //Validate that the I agree checkbox is checked by default
    	driver.findElement(By.xpath("//span[contains(text(),'I agree to receive promotional communication.')]")).isSelected();
    //Enter name
    	driver.findElement(By.id("checkout__name")).sendKeys("uma R");
    	//ENTER A PHONE NUMBER
    	driver.findElement(By.id("checkout__phone")).sendKeys("+91-9080327791");
    	//enter a email
    	driver.findElement(By.id("checkout__email")).sendKeys("umaraaj6758@gmail.com");
    	//Click on the Apply Gift Card link
    	driver.findElement(By.cssSelector("[class='sc-fzqMdD eohbfP']")).click();
        //A pop up should appear. Click on the Voucher
        driver.findElement(By.cssSelector("[class='sc-fzoant smfTD p-10 pt-20 bg-white m-20 rounded shadow relative']")).isDisplayed();
        //Give the Voucher code as 12345 and submit
        driver.findElement(By.cssSelector("[class='sc-fznMnq gdZumo']")).click();
        driver.findElement(By.name("voucherId")).sendKeys("12345");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        //Validate if an error is coming that the number is incorrect
        String ErrorMessage = driver.findElement(By.xpath("//div[@class='sc-fznJRM ciBEcK']//span")).getText();
        AssertJUnit.assertEquals(ErrorMessage, "Sorry, we don’t currently support that coupon code.");
        
        
        
        
        

}
	
}
