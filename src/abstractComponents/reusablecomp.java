package abstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class reusablecomp {
	public WebDriver driver;
	public reusablecomp(WebDriver driver){
	 this.driver = driver;
	 PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//a[text()='Medicare']")
	WebElement medicare;
	@FindBy(xpath="//a[text()='About']")
	WebElement about;
	@FindBy(xpath="//a[text()='Contact']")
	WebElement contact;
	
	
	
	
	
	
	
	
	
}


