package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.reusablecomp;

public class deletelockedmessage extends reusablecomp {

	
		
		// TODO Auto-generated method stub
		public WebDriver driver;
		public deletelockedmessage(WebDriver driver){
			super(driver);
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
		
		@FindBy(css=".fe.fe-trash")
		List<WebElement> trash;
		@FindBy(xpath="//div[@class= 'd-flex justify-content-center mt-3']/button/following-sibling::button")
		WebElement deleteButton;
		public void deletePermanently() {
			deleteButton.click();
		}
		
		public void delete_locked_message() {
			trash.get(1).click();
		}
	}

	


