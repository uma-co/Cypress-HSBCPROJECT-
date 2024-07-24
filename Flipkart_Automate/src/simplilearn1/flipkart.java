package simplilearn1;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.apache.hc.core5.util.Asserts;
import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.Streams;

import BaseTest.btest;
import PageObjects.Homepage;
import PageObjects.productsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkart extends btest{
	public static WebDriver driver;
@Test
	public void endtoend() throws IOException, InterruptedException {
		Homepage Homepage = launchbrowserUrl();
		Homepage.searchbox("laptop");
		
		Homepage.searchedValuepresentinsearch("LapTop");
	
		productsPage productsPage = Homepage.getTitleproductspage();
		productsPage.clickOnLap();
		productsPage.windowschange();
		productsPage.addToCart();
		
		
		
		
		
	//user Registration
		
//		User Registration:
//			○ Navigate to the registration page.
//		driver.findElement(By.xpath("(//a[@title=\"Login\"])[1]")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0, 470)", " ");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[text()='New to Flipkart? Create an account']")).click();
//		
////		
//////			○ Fill in the registration form with valid details.
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("6381334383");
//		driver.findElement(By.xpath("(//button[@type=\"submit\"])[2]")).click();
//		
//		driver.findElement(By.xpath("//button[text()='Request OTP']")).click();
//		
//		
//		List<WebElement> otp = driver.findElements(By.xpath("//input[@class='r4vIwl IX3CMV']"));
//		for(int i=0 ;i<otp.size(); i++) {
//			otp.get(i).sendKeys("767897");
//		}
//		
//		
//////			○ Verify that the user is registered successfully and redirected to the dashboard
//////			or homepage.
//		System.out.println(driver.getTitle());
//		
//		//driver.navigate().back();
//		
////		3. Product Search:
////			○ Navigate to the homepage.
//		Thread.sleep(3000);
//		Set<String> address = driver.getWindowHandles();
//		Iterator it =   address.iterator();
//		Object parentaddress = it.next();
//		Object childAddress = it.next();
//		driver.switchTo().window((String) childAddress);
//			○ Use the search functionality to find a specific product (e.g., "Laptop").
		
//		 driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("Laptop", Keys.ENTER);
//	   WebElement label = driver.findElement(By.xpath("//span[@class='BUOuZu']"));
//	    System.out.println(label.getText().contains("Laptop"));
	    
	    ////a[@class='CGtC98']/div[@class='Otbq5D']
	    
//	     4. Product Purchase:
//	    	 ○ Select a product from the search results.
//	List<WebElement> title = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
//	System.out.println(title.size());
////	List<WebElement> pages  = driver.findElements(By.cssSelector(".cn++Ap"));
//	WebDriverWait waities = new WebDriverWait(  driver, 5);
//   
	//JavascriptExecutor js = (JavascriptExecutor) driver;
//	js.executeScript("window.scrollBy(0,2000)", "");
	Thread.sleep(2000);
//	driver.findElement(By.xpath("//div[text()='ASUS Vivobook 15 Intel Core i5 12th Gen 1235U - (8 GB/512 GB SSD/Windows 11 Home) X1502ZA-EJ515WS Thin...']")).click();
////	for(int i = 0; i < title.size(); i++) {
////		if(title.get(i).getText().equalsIgnoreCase("Lenovo")) {
////			System.out.println(title.get(i).getText());
////			Thread.sleep(3000);
////			title.get(i).click();
//////			WebElement addbutton = driver.findElement(By.xpath("//span[@class='Lni97G']"));
//////			waities.until(ExpectedConditions.visibilityOf(addbutton)).click();
////			
////		}
//	
//	//}
////	Set<String> address1 = driver.getWindowHandles();
////	Iterator it1= address1.iterator();
////	Object parentaddress1 = it1.next();
////	Object ChildAddress = it1.next();
////	driver.switchTo().window((String) ChildAddress);
////	System.out.println(driver.getTitle());
//	WebElement addbuton = driver.findElement(By.xpath("(//li[@class='col col-6-12'])[1]"));
//	js.executeScript("arguments[0].scrollIntoView(true);", addbuton);
//	Thread.sleep(5000);
////	js.executeScript("window.scrollBy(0, document.body.scrollHeight)" ," ");
////	Thread.sleep(5000);
//	js.executeScript("window.scrollBy(0, 4300)");
//	WebDriverWait wait = new WebDriverWait(driver, 5);
//	wait.until(ExpectedConditions.visibilityOf(addbuton)).click();
//	
//	
//	

	//driver.findElement(By.xpath("(//li[@class='col col-6-12'])[1]")).click();
	
	
	//driver.findElement(By.xpath("//span[text()='COMPARE']")).click();
	    
//	    	 ○ Add the product to the cart.
	 //   List<WebElement> addButton =  driver.findElements(By.xpath("//span[text()='Add to Compare']"));
	    
	     
	    
	}}
	    
	
	
	
	
	
	
	
	
	
	
	



	
	
	
	
	
	

	

