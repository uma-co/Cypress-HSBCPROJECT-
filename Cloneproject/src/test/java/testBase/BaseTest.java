package testBase;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;





public class BaseTest {

	public static WebDriver driver;
	@BeforeClass
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "/home/umaraaj1999gmai/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://localhost:80/ecomm");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	
	}
	
	
}
