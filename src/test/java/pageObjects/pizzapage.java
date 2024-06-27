package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pizzapage extends abstractComponents{
	
	WebDriver driver;
	public  pizzapage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this );
		
	}
	
	//pizza menu functionalities
//	WebElement sideslink = driver.findElement(By.xpath("(//a[@href='/order/sides/'])[2]"));
@FindBy(xpath=("(//a[@href='/order/sides/'])[2]"))
WebElement sidesLink;
// List<WebElement> listofsides= driver.findElements(By.xpath("//div[contains(text(),'BBQ Baked Chicken Wings 6 Pcs')]"));
@FindBy(xpath=("//div[contains(text(),'BBQ Baked Chicken Wings 6 Pcs')]"))
List<WebElement> sideDishes;
//      List<WebElement> AddButton = driver.findElements(By.xpath("//button[@class='button button--md button--green flex-1 font-semibold']"));
@FindBy(xpath=("//button[@class='button button--md button--green flex-1 font-semibold']"))
List<WebElement> sideDishesAddButton;
// WebElement basket=  driver.findElement(By.cssSelector("[data-synth='basket-item-type--side']"));
@FindBy(css=("[data-synth='basket-item-type--side']"))
WebElement basket;

public void sidesLinkMenu() {
	sidesLink.click();
}

public void selectingElementsInSides() {
	 for(int i=0; i<sideDishes.size(); i++) {
			if(sideDishes.get(i).getText().contains("BBQ Baked Chicken Wings 6 Pcs")) {
				System.out.println(sideDishes.get(i).getText());
				//driver.findElement(By.xpath("(//button[@class='button button--md button--green flex-1 font-semibold'])["+i+"]")).click();
				sideDishesAddButton.get(i).click();
			}
		   }
}
	 
	 public drinkspage basketelement() {
		 if(basket.getText().contains("Cheezy Sprinkled Fries")) {
		    	System.out.println(basket.getText() + " is added in the basket");
		    	    }
		scrollUp();
		return new drinkspage(driver);
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
