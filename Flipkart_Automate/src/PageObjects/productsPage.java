package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



	public class productsPage extends abstractComp {
		WebDriver driver;
	public productsPage(WebDriver driver){
		    super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this );
			}
	// driver.findElement(By.xpath("//div[text()='ASUS Vivobook 15 Intel Core i5 12th Gen 1235U - (8 GB/512 GB SSD/Windows 11 Home) X1502ZA-EJ515WS Thin...']")).click();
		@FindBy(xpath= "//div[text()='ASUS Vivobook 15 Intel Core i5 12th Gen 1235U - (8 GB/512 GB SSD/Windows 11 Home) X1502ZA-EJ515WS Thin...']")
		WebElement vivoLap;
	//  WebElement addbuton = driver.findElement(By.xpath("(//li[@class='col col-6-12'])[1]"));
		@FindBy(xpath= "(//li[@class='col col-6-12'])[1]")
		WebElement addButton;

	
	public void windowschange() {
		windowHandles();
	}
	public void clickOnLap() {
		vivoLap.click();
	}
	public void addToCart() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", addButton);
//		Thread.sleep(5000);
//		js.executeScript("window.scrollBy(0, document.body.scrollHeight)" ," ");
//		Thread.sleep(5000);
		js.executeScript("window.scrollBy(0, 4300)");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(addButton)).click();
		
	}
	
	}
