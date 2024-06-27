package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import testBase.BaseTest;

public class Home extends BaseTest{
	@Test
	public  static void  HomePageTest() throws InterruptedException {
		BaseTest bt = new BaseTest();
		bt.openBrowser();
		Actions act = new Actions(driver);
		WebElement pagesHover = driver.findElement(By.xpath("//li[@class='cn-dropdown-item has-down pr12']"));
		Thread.sleep(3000);
		act.moveToElement(pagesHover).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@href='contact.html'])[1]")).click();
		
	}
	
//	public static void main (String[] args ){
//		HomePageTest();
//		
//	}
}
