package BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageObjects.Homepage;
import cucumber.Options.ItestListener;

import reports.ExtentReport;
@Listeners({ItestListener.class})

	public class btest  {

	protected WebDriver driver;
	 protected static ExtentReports extent;
	 protected static ExtentTest extentest;
	 @BeforeClass
	 public static void initializeReports() {
		 
		 extent=ExtentReport.reports();
	 }
	 @AfterClass
	 public static void tearDown() {
		 extent.flush();
	 }
	 
    public WebDriver initializeBrowser() throws IOException {
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//BaseTest//Global.properties");
	prop.load(fis);
	String browser = prop.getProperty("browser");
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "/home/umaraaj1999gmai/Downloads/chromedriver");
		
		 driver = new ChromeDriver();
	}
	 driver.manage().window().maximize();
	 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	return driver;
    }
    public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
    	TakesScreenshot ts =	(TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File path = new File(System.getProperty("user.dir")+"//reports"+testcasename+".png");
    	FileUtils.copyFile(src, path);
    	return System.getProperty("user.dir")+"//reports"+testcasename+".png";
    }
    
    public  Homepage launchbrowserUrl() throws IOException {
    	driver = initializeBrowser();
    	Homepage homepage = new Homepage(driver);
    	homepage.goTo();
    	return homepage;
    	
    	
    }
    @AfterTest
    public void teardownTest() {
    	if(driver != null) {
    		driver.close();
    	}
    	
    }
    
   
    
    
    }
    
    
    
    

