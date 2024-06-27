package testBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;



public class BaseTest {

	public static WebDriver driver;
	@org.junit.BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/home/umaraaj1999gmai/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:80/ecomm");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
	public void scrolldown() {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		    js.executeScript("window.scrollBy(0,250)", "");
	}
	@org.junit.AfterClass
	public void teardown() {
		driver.close();
	}
	public void nestedScroll() {
		WebElement nestedScroll =driver.findElement(By.id("ascrail2000"));
		
		Actions act = new Actions(driver);
		WebElement nested = driver.findElement(By.cssSelector(".cart-amount-summary"));
		act.clickAndHold(nested).keyDown(Keys.DOWN).build().perform();
		//act.keyDown(nestedScroll, Keys.ARROW_DOWN).build().perform();
		act.moveToLocation(0, 250).keyDown(Keys.ARROW_DOWN).build().perform();
		act.clickAndHold(nestedScroll).keyDown(Keys.ARROW_DOWN).build().perform();
		act.clickAndHold(nestedScroll).keyDown(Keys.ARROW_DOWN).build().perform();
		act.clickAndHold(nestedScroll).keyDown(Keys.ARROW_DOWN).build().perform();
	
		
	}
}
