package test;


import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Demotest {

	@Test
	public static void demo(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver", "/home/umaraaj1999gmai/Downloads/chromedriver");
		driver = new ChromeDriver();
		 driver.get("https://www.pizzahut.co.in/");
		 driver.manage().window().maximize();
	}
}
