package PageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public  class abstractComp{


	
		// TODO Auto-generated constructor stub
		WebDriver driver;
		public abstractComp(WebDriver driver){
			
				this.driver = driver;
				PageFactory.initElements(driver, this);
	}

	
		public void scrollDown() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 470)", " ");
		}

		
		
		public void explicitwaitforelement(By findBY) {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(findBY));	
		}
		
		public void windowHandles() {
			
			Set<String> address1 = driver.getWindowHandles();
			Iterator it1= address1.iterator();
			Object parentaddress1 = it1.next();
			Object ChildAddress = it1.next();
			driver.switchTo().window((String) ChildAddress);
			System.out.println(driver.getTitle());
		}
		
		
		


}