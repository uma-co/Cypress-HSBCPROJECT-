package standalonepackage.copy;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PizzaHutcom {
	public static WebDriver driver;

	
	public static void main (String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "/home/umaraaj1999gmai/Downloads/chromedriver");
		
		 driver = new ChromeDriver();
		 driver.get("https://www.pizzahut.co.in");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 470)", " ");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			//1-visibility
		WebElement elemendisplay = 	driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']"));
		System.out.println(elemendisplay.isDisplayed());
		//location providing
		WebElement chennai = driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']"));
		chennai.sendKeys("chen");
		// selecting dropdown - 1st
		
		driver.findElement(By.xpath("(//button[@class='text-left pl-15 py-10 border-t border-l-0 border-r-0 border-b-0 border-grey-lightest border-solid suggestion-item'])[1]")).click();
//		WebElement popup = driver.findElement(By.cssSelector("[class=\"mx-auto px-20 text-white\"]"));
//		wait.until(ExpectedConditions.elementToBeClickable(popup));
//		driver.findElement(By.xpath("//button[@class='button button--secondary text-center']")).click();
		
		System.out.println(driver.getCurrentUrl());
		//Assert.assertEquals(driver.getCurrentUrl(), "https://www.pizzahut.co.in/order/deals/");
		
		System.out.println(driver.findElement(By.xpath("(//span[@class='py-4 px-5 border rounded-full flex items-center cursor-pointer bg-grey-light border-grey-light justify-start'])[2]")).isEnabled());
		List<WebElement> pizzamenu = 	driver.findElements(By.xpath("//a[@href='/order/pizzas/']"));
		for(int i =0 ; i<= pizzamenu.size() ;) {
			pizzamenu.get(1).click();
			break;
			
		}
		 List<WebElement> pizzaAddButton = driver.findElements(By.xpath("//button[@class='button button--md button--green flex-1 font-semibold']//span[text()='Add']"));
		List<WebElement> pizzas = driver.findElements(By.cssSelector(".typography-4.list-item__name.flex-1.px-10.pt-10"));
		System.out.println(pizzas.size());
		for(int i=0 ; i < pizzas.size(); i++) {
		     if(pizzas.get(i).getText().contains("Awesome American Cheesy")) {
		    		 
		    		 
              	 System.out.println(pizzas.get(i).getText());
              	pizzaAddButton.get(i).click(); 
	    	}
		   }
		//Then User see that the pizza is getting added under Your Basket
		String added_items = driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']")).getText();
		
		Assert.assertEquals(added_items, "4 items");
		
		//-And User validate pizza price plus Tax is checkout price
		List<WebElement> pizzaPrice = driver.findElements(By.cssSelector(".basket-item-product-price.leading-tight.bold.text-15.text-black"));
		int sum=0;
		System.out.println(pizzaPrice.size());
		for(int i=0 ; i< pizzaPrice.size();i++) {
			String EACHPIZZAPRICE = pizzaPrice.get(i).getText().split("₹")[1];
			int value = Integer.parseInt(EACHPIZZAPRICE);
			sum+=value;
			System.out.println(sum);
		}
		String subtotal = driver.findElement(By.xpath("//span[text()='₹1436.00']")).getText().split("₹")[1];
		Assert.assertEquals(subtotal, "1436.00");
		WebElement taxdropdown =     driver.findElement(By.cssSelector(".mr-5.opacity-25.text-grey.cursor-pointer.z-1.block.icon-chevron-right"));
		taxdropdown.click();
	List<WebElement> tax =	driver.findElements(By.xpath("//div[@class='flex justify-between items-start text-grey']/div[2]"));
	System.out.println(tax.size());
	long taxproce = 0;
		for(int i=0; i<tax.size();i++) {
			String tax_value = tax.get(i).getText().split("₹")[1];
//		    Long consolidated_price = Long.parseLong(tax_value);
//		    taxproce += consolidated_price;
//		    System.out.println(consolidated_price);
		}
		//Then User validate checkout button contains Item count
		WebElement itemscountinCheckout = driver.findElement(By.xpath("//a[@href='/order/checkout/']//span[@class='bg-green-dark pl-5 pr-5 rounded']"));
		Assert.assertEquals(itemscountinCheckout.getText(), "4 items");
		// And User validate checkout button contains total price count
		String Price_Count = driver.findElement(By.xpath("//a[@href='/order/checkout/']//span[@data-synth='basket-value']")).getText().split("₹")[1];
		System.out.println(Price_Count);
		//-Then User clicks on Drinks option
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("window.scrollBY(0 ,-550)");
//		WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href='/order/drinks/'])[1]")));
		
		driver.findElement(By.xpath("(//a[@href='/order/drinks/'])[2]")).click();
		//clicking on pepsi
		List<WebElement> drinksCount =  driver.findElements(By.cssSelector(".typography-4.list-item__name.flex-1.px-10.pt-10"));
	  
		List<WebElement> addButton = driver.findElements(By.xpath("//button[@class = 'button button--md button--green flex-1 font-semibold']/span[1]")); 
		
		for(int i=0 ; i < drinksCount.size(); i++) {
			
			if(drinksCount.get(i).getText().contains("Pepsi - 475ml")) {
				addButton.get(i).click();
				
			}
		}
		//total itmes visible
		
		
		String TotalItems = driver.findElement(By.cssSelector("[class='bg-green-dark pl-5 pr-5 rounded']")).getText();
		Assert.assertEquals(TotalItems, "5 items");
		
		// total amount is higher than earlier
		String currentTotal =  driver.findElement(By.cssSelector("[class='ml-auto text-right']")).getText().split("₹")[1];
		System.out.println(currentTotal);
//		long curval = Long.parseLong(currentTotal);
//		System.out.println(curval);
		
//		if(currentTotal > sum) {
//			System.out.println("Current total is greater than old value and the value is "+currentTotal );
//		}
		//Then User remove the Pizza item from Basket
		List<WebElement> removeFromBasket  = driver.findElements(By.xpath("//button[@class='icon-close relative opacity-25 text-grey ml-10 p-10']"));
		for(int k =0 ; k< removeFromBasket.size()-1; k++ ) {
			removeFromBasket.get(k).click();
		}
		// price gotremoved
		
		//driver.findElement(By.cssSelector(".mr-auto.text-right")).isDisplayed();
		
	//  1itmes is showing
	String OneItem	= driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']")).getText();
		Assert.assertEquals(OneItem, "1 item");
		//Then User Clicks on Checkout button
		
		driver.findElement(By.xpath("(//span[@class='absolute inset-0 flex-center'])[2]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class= 'pt-20 bg-white p-20 m-20 rounded text-center shadow relative']")).isDisplayed());
		
		
		
	}}
