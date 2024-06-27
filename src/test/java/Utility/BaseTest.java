package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import pageObjects.HomePage;
import pageObjects.Homepage;

public class BaseTest {

	
		WebDriver driver;
	    public WebDriver initializeBrowser() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//Utility//Global.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/umaraaj1999gmai/Downloads/chromedriver");
			
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
	    	FileUtils.copyFile(src, path);
	    	return System.getProperty("user.dir")+"//reports"+testcasename+".png";
	    	
	    	
	    	
	    }
	    public Homepage launchapp() throws IOException {
	    	driver = initializeBrowser();
	    	Homepage hp = new Homepage(driver);
	    	hp.goT();
	    	return hp;
	    	
	    }

		
	
}
