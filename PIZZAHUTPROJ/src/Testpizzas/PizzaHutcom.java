package Testpizzas;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.btest;
import cucumber.Options.ItestListener;
import pageObjects.HomePage;
import pageObjects.ordersPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//@Listeners(ItestListener.class)
public class PizzaHutcom extends btest {


	WebDriver driver;
	
//	public static void main (String[] args) throws InterruptedException, IOException{
//		System.setProperty("webdriver.chrome.driver", "/home/umaraaj1999gmai/Downloads/chromedriver");
	@Test
	public void endToend() throws IOException, InterruptedException {
//		 driver = new ChromeDriver();
		HomePage HomePage = launchbrowserUrl();
//		HomePage.locationpopup();
		// HomePage HomePage = new HomePage(driver);

		 HomePage.goTo();
		 HomePage.locationpopup();
		//extentest.info("locationpopupopen");
//		 driver.manage().window().maximize();
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollBy(0, 470)", " ");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			//1-visibility
			HomePage.elementToBeDisplay("chen");
			ordersPage ordersPaage = HomePage.firstdropDown();
			//HomePage.starttheOrder();
			
//			HomePage.addressnotfound();

		//System.out.println(driver.getCurrentUrl());
		ordersPaage.ordersPage();
	ordersPaage.radiobuton();
		//System.out.println(driver.findElement(By.xpath("(//span[@class='py-4 px-5 border rounded-full flex items-center cursor-pointer bg-grey-light border-grey-light justify-start'])[2]")).isEnabled());
		ordersPaage.pizzalink();
		

		// List<WebElement> pizzaAddButton = driver.findElements(By.xpath("//button[@class='button button--md button--green flex-1 font-semibold']//span[text()='Add']"));
		//List<WebElement> pizzas = driver.findElements(By.cssSelector(".typography-4.list-item__name.flex-1.px-10.pt-10"));
		//System.out.println(pizzas.size());
		ordersPaage.pizzaAddingintoBasket();

		
		ordersPaage.addedItemsInBasket();
		Assert.assertEquals(ordersPaage.addedItemsInBasket(), "4 items");
		
		//-And User validate pizza price plus Tax is checkout price
		//List<WebElement> pizzaPrice = driver.findElements(By.cssSelector(".basket-item-product-price.leading-tight.bold.text-15.text-black"));
		
		//System.out.println(pizzaPrice.size());
		ordersPaage.pizzaprices();


		
		Assert.assertEquals(ordersPaage.totalPrice(), "1436.00");
		driver.findElement(By.id("button")).click();
		
		
		ordersPaage.taxDRopDown();
//	List<WebElement> tax =	driver.findElements(By.xpath("//div[@class='flex justify-between items-start text-grey']/div[2]"));
//	System.out.println(tax.size());
			
  ordersPaage.tax();
	Assert.assertEquals(ordersPaage.itemsCountINCheckOut(), "4 items");
		ordersPaage.pricecount();
		//-Then User clicks on Drinks option
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		ordersPaage.drinksMenu();
        ordersPaage.drinkSelection();
		Assert.assertEquals(ordersPaage.items_totslincheckout(), "5 items");
		System.out.println(ordersPaage.currentTot());

		ordersPaage.removefrombasket();
		Assert.assertEquals(ordersPaage.itmesinthecheckout(), "1 item");
		//ordersPaage.priceTag();
		ordersPaage.checkout();
		
		ordersPaage.dialogbox();
	//	ordersPaage.tearDown();
		
		
	}}
