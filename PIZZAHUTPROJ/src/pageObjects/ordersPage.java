package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ordersPage extends abstractComponents {
	
	WebDriver driver;
	public ordersPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this );
		}
	//System.out.println(driver.findElement(By.xpath("(//span[@class='py-4 px-5 border rounded-full flex items-center cursor-pointer bg-grey-light border-grey-light justify-start'])[2]")).isEnabled());
	
	@FindBy (xpath = "(//span[@class='py-4 px-5 border rounded-full flex items-center cursor-pointer bg-grey-light border-grey-light justify-start'])[2]")
	WebElement radioButton;
	//List<WebElement> pizzamenu = 	driver.findElements(By.xpath("//a[@href='/order/pizzas/']"));
	@FindBy (xpath = "//a[@href='/order/pizzas/']")
	List<WebElement> pizzamenuLInk;
	//List<WebElement> pizzaAddButton = driver.findElements(By.xpath("//button[@class='button button--md button--green flex-1 font-semibold']//span[text()='Add']"));
	@FindBy (xpath = "//button[@class='button button--md button--green flex-1 font-semibold']//span[text()='Add']")
	List<WebElement> pizzaAddButton;
	//List<WebElement> pizzas = driver.findElements(By.cssSelector(".typography-4.list-item__name.flex-1.px-10.pt-10"));
	@FindBy (css = ".typography-4.list-item__name.flex-1.px-10.pt-10")
	List<WebElement> collectionOfPizzas;
	//String added_items = driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']")).getText();
	@FindBy (xpath = "//span[@class='bg-green-dark pl-5 pr-5 rounded']")
	WebElement addedItems;
	//List<WebElement> pizzaPrice = driver.findElements(By.cssSelector(".basket-item-product-price.leading-tight.bold.text-15.text-black"));
	@FindBy (css = ".basket-item-product-price.leading-tight.bold.text-15.text-black")
	List<WebElement> pizzaPrice;
	//String subtotal = driver.findElement(By.xpath("//span[text()='₹1436.00']")).getText().split("₹")[1];
	@FindBy (xpath = "//span[text()='₹1436.00']")
	WebElement subtotal;
	//WebElement taxdropdown =     driver.findElement(By.cssSelector(".mr-5.opacity-25.text-grey.cursor-pointer.z-1.block.icon-chevron-right"));
	@FindBy (css = ".mr-5.opacity-25.text-grey.cursor-pointer.z-1.block.icon-chevron-right")
	WebElement taxdropdown;
	//List<WebElement> tax =	driver.findElements(By.xpath("//div[@class='flex justify-between items-start text-grey']/div[2]"));
	@FindBy (xpath = "//div[@class='flex justify-between items-start text-grey']/div[2]")
	List<WebElement> tax;
	//WebElement itemscountinCheckout = driver.findElement(By.xpath("//a[@href='/order/checkout/']//span[@class='bg-green-dark pl-5 pr-5 rounded']"));
	@FindBy (xpath = "//a[@href='/order/checkout/']//span[@class='bg-green-dark pl-5 pr-5 rounded']")
	WebElement itemsCountInCheckout;
	//String Price_Count = driver.findElement(By.xpath("//a[@href='/order/checkout/']//span[@data-synth='basket-value']")).getText().split("₹")[1];
	@FindBy (xpath = "//a[@href='/order/checkout/']//span[@data-synth='basket-value']")
	WebElement Price_Count;
	//driver.findElement(By.xpath("(//a[@href='/order/drinks/'])[2]")).click();
	@FindBy (xpath = "(//a[@href='/order/drinks/'])[2]")
	WebElement drinksSelection;
	//List<WebElement> drinksCount =  driver.findElements(By.cssSelector(".typography-4.list-item__name.flex-1.px-10.pt-10"));
	@FindBy (css = ".typography-4.list-item__name.flex-1.px-10.pt-10")
	List<WebElement> drinksCount;
	//List<WebElement> addButton = driver.findElements(By.xpath("//button[@class = 'button button--md button--green flex-1 font-semibold']/span[1]")); 
	@FindBy (xpath = "//button[@class = 'button button--md button--green flex-1 font-semibold']/span[1]")
	List<WebElement> addButton;
	//String TotalItems = driver.findElement(By.cssSelector("[class='bg-green-dark pl-5 pr-5 rounded']")).getText();
	@FindBy (css = "[class='bg-green-dark pl-5 pr-5 rounded']")
	WebElement TotalItems;
	//String currentTotal =  driver.findElement(By.cssSelector("[class='ml-auto text-right']")).getText().split("₹")[1];
	@FindBy (css = "[class='ml-auto text-right']")
	WebElement currentTotal;
	//List<WebElement> removeFromBasket  = driver.findElements(By.xpath("//button[@class='icon-close relative opacity-25 text-grey ml-10 p-10']"));
	@FindBy (xpath = "//button[@class='icon-close relative opacity-25 text-grey ml-10 p-10']")
	List<WebElement> removeFromBasket;
	//String OneItem	= driver.findElement(By.xpath("//span[@class='bg-green-dark pl-5 pr-5 rounded']")).getText();
	@FindBy (xpath = "//span[@class='bg-green-dark pl-5 pr-5 rounded']")
	WebElement OneItem;
	//driver.findElement(By.xpath("(//span[@class='absolute inset-0 flex-center'])[2]")).click();
	//System.out.println(driver.findElement(By.xpath("//div[@class= 'pt-20 bg-white p-20 m-20 rounded text-center shadow relative']")).isDisplayed());
	@FindBy (xpath = "(//span[@class='absolute inset-0 flex-center'])[2]")
	WebElement checkout;
	@FindBy (xpath = "//div[@class= 'pt-20 bg-white p-20 m-20 rounded text-center shadow relative']")
	WebElement checkoutScreen;
	@FindBy(xpath = "//div[@aria-label=\"HutRewards\"]/div")
	WebElement DialogBox;
	@FindBy(xpath= "(//span[@data-synth='basket-value'])[2]")
	WebElement pricetag;
	@FindBy (xpath = "//p[@class='hidden lg:inline']")
	WebElement detailsPage;
	
	public void ordersPage() {
		detailsPage.isDisplayed();
	}
	
	public void radiobuton() {
		System.out.println("radioButton is" + radioButton.isEnabled());
	}
	public void pizzalink() {
		for(int i =0 ; i<= pizzamenuLInk.size() ;) {
			pizzamenuLInk.get(1).click();
			break;
			
			
		}
	}
	public void pizzaAddingintoBasket() {
		for(int i=0 ; i < collectionOfPizzas.size(); i++) {
		     if(collectionOfPizzas.get(i).getText().contains("Awesome American Cheesy")) {
		    		 
		    		 
             	 System.out.println(collectionOfPizzas.get(i).getText());
             	pizzaAddButton.get(i).click(); 
	    	}
		   }
		}
	public String addedItemsInBasket() {
		String Value = addedItems.getText();
		return Value;
}
	public void pizzaprices() {
		int sum=0;
		for(int i=0 ; i< pizzaPrice.size();i++) {
			String EACHPIZZAPRICE = pizzaPrice.get(i).getText().split("₹")[1];
			int value = Integer.parseInt(EACHPIZZAPRICE);
			sum+=value;
			System.out.println(sum);
		}
	}
	
	public String totalPrice() {
		String priceValue = subtotal.getText().split("₹")[1];
		return priceValue;
	}
	
	public void taxDRopDown() {
		taxdropdown.click();
	}
	
	public void tax() {
		long taxproce = 0;
		for(int i=0; i<tax.size();i++) {
			String tax_value = tax.get(i).getText().split("₹")[1];
//		    Long consolidated_price = Long.parseLong(tax_value);
//		    taxproce += consolidated_price;
    System.out.println("The tax Value is " +tax_value);
			
		}
	
	
	}
	public String itemsCountINCheckOut() {
		return itemsCountInCheckout.getText();
	}
	public void pricecount() {
		String count = Price_Count.getText().split("₹")[1];
		System.out.println(count);
	}
	public void drinksMenu() {
		drinksSelection.click();
	}
	
	public void drinkSelection() {
for(int i=0 ; i < drinksCount.size(); i++) {
			
			if(drinksCount.get(i).getText().contains("Pepsi - 475ml")) {
				addButton.get(i).click();
				
			}
		}
	}

   public String items_totslincheckout() {
	  return TotalItems.getText();
		
   }
   public String currentTot() {
	  return currentTotal.getText().split("₹")[1];
	}
   public void removeItemfromBasket() {
	   for(int k =0 ; k< removeFromBasket.size()-1; k++ ) {
			removeFromBasket.get(k).click();
		}
   }
   
   public String itmesinthecheckout() {
	   return OneItem.getText();
   }
   
   public void removefrombasket() {
	   List<WebElement> removeFromBasket  = driver.findElements(By.xpath("//button[@class='icon-close relative opacity-25 text-grey ml-10 p-10']"));
	for(int k =0 ; k< removeFromBasket.size()-1; k++ ) {
		removeFromBasket.get(k).click();
	}
   }
   public void checkout() throws InterruptedException {
	   Thread.sleep(3000);
   checkout.click();
   checkoutScreen.isDisplayed();
   }
   
   public void priceTag() {
	  if(! pricetag.isDisplayed()){
		  System.out.println("price tag not displayed");
	  }
   }
   public void dialogbox() {
	 //div[@aria-label="HutRewards"]/div
	   DialogBox.isDisplayed();
   }
    public void tearDown() {
    	driver.close();
    }
	
	
	
	
	
	
	
	
	
	

}
