package test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
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
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utility.BaseTest;

import pageObjects.Homepage;
import pageObjects.checkoutPage;
import pageObjects.drinkspage;
import pageObjects.pizzapage;

public class seltest extends BaseTest {
	
@Test
	public static void main(String[] args) throws InterruptedException, IOException {
	//public static void standalone() throws InterruptedException {
//System.setProperty("webdriver.chrome.driver", "/home/umaraaj1999gmai/Downloads/chromedriver");
//	
//	 WebDriver driver = new ChromeDriver();
//	 driver.get("https://www.pizzahut.co.in/");
//	 driver.manage().window().maximize();
//	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	Homepage hp = new Homepage(driver);
    hp = launchapp();	
     
	 hp.enteringLoc();
	 

	 hp.dropdownselection();
     Thread.sleep(5000);

     pizzapage pizzapage = hp.dealsUrl();
     
     pizzapage.sidesLinkMenu();
     pizzapage.selectingElementsInSides();


     drinkspage drinkspage =  pizzapage.basketelement();

     drinkspage.drinkmenuLInk();


     checkoutPage checkoutPage = drinkspage.drinksSelection();
    	
     checkoutPage.checkoutbutton();
     
     checkoutPage.radiobutton();
    
     checkoutPage.casbutton();
       
     checkoutPage.checkbox();
    
     checkoutPage.Details();
    	
     checkoutPage.voucherTab();
     checkoutPage.voucher();
     String ErrorMessage = checkoutPage.ErrorMessage();

       AssertJUnit.assertEquals(ErrorMessage, "Sorry, we don’t currently support that coupon code.");
        
        
        
        
        

}
	
}
