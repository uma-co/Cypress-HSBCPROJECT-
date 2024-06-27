package abstract_Com;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstract_class {
	WebDriver driver;
	public Abstract_class(WebDriver driver){
		    
			this.driver = driver;
			PageFactory.initElements(driver, this );
			}
	@FindBy(xpath="(//a[@href='checkout.html'])[2]")
	WebElement loci;
	
	public void webdriverwait() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(loci));
	}
}
