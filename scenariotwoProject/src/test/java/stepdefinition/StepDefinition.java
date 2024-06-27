package stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import testBase.BaseTest;

public class StepDefinition extends BaseTest{

	BaseTest BaseTest = new BaseTest();
	@Given("user is on ecomm page")
	public void user_is_on_ecomm_page() {
		BaseTest.openBrowser();  
	}

	@And("If the user is able to click on the Add to Cart button")
	public void if_the_user_is_able_to_click_on_the_add_to_cart_button() {
	    driver.findElement(By.id("essenceCartBtn")).click();
	   
	}

	@And("If the user is able to click on the Checkout button")
	public void if_the_user_is_able_to_click_on_the_checkout_button() throws InterruptedException {
		Thread.sleep(5000);
		BaseTest.scrolldown();
		BaseTest.nestedScroll();
	    driver.findElement(By.xpath("(//a[@href='checkout.html'])[2]")).click();
	}

	@And("If the user is able to add all required details in the Billing Address page")
	public void if_the_user_is_able_to_add_all_required_details_in_the_billing_address_page() {
	  driver.findElement(By.id("first_name")).sendKeys("uma");
	 driver.findElement(By.id("last_name")).sendKeys("R");
	 BaseTest.scrolldown();
	 driver.findElement(By.cssSelector(".nice-select.w-100")).click();
	List<WebElement> dropdown = driver.findElements(By.cssSelector("[class='option']"));
	//dropdown.stream().filter(f->f.getAttribute("data-value")).findFirst();
	for(int i =0 ; i< dropdown.size() ; i++) {
		if(dropdown.get(i).getText().contains("india")) {
			dropdown.get(i).click();
		}
	}
	driver.findElement(By.id("postcode")).sendKeys("34535");
	driver.findElement(By.id("city")).sendKeys("chidambaram");
	driver.findElement(By.id("state")).sendKeys("TamilNadu");
	driver.findElement(By.id("phone_number")).sendKeys("9080327791");
	driver.findElement(By.id("email_address")).sendKeys("umaraaj1999@gmail.com");
   
	}

	@And("If the user is able to click on the Place Order button")
	public void if_the_user_is_able_to_click_on_the_place_order_button() {
	   driver.findElement(By.xpath("(//a[@class='btn essence-btn'])[2]")).click();
	}



}
