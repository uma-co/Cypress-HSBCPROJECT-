package utils;

import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	public static WebDriver initializeBrowser() throws IOException   {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//browser_operation.properties");
		prop.load(fis);
		String browser = System.getProperty("browser")!= null ? System.getProperty("browser"):prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "/home/umaraaj1999gmai/Downloads/chromedriver");
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	    }
	public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
    	TakesScreenshot ts =	(TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File path = new File(System.getProperty("user.dir")+"//reports"+testcasename+".png");
    	Files.copy(src, path);
    	return System.getProperty("user.dir")+"//reports"+testcasename+".png";
	}
	public void jsExecutor() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	@BeforeMethod
	public  void launchapp() throws IOException {
 	    	driver = initializeBrowser();
 	    	driver.get("https://app.thepric.com/lm/");
 	    	
 	    }
// 	    @AfterMethod(alwaysRun=true)
// 	    public void teardownTest() {
// 	    	if(driver != null) {
// 	    		driver.quit();
// 	    	}
}


