package definition;

import java.io.IOException;

import org.testng.Assert;

import BaseTest.btest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.ordersPage;

public class stepdefinition extends btest {
	HomePage HomePage;
	ordersPage ordersPaage;
	@Given("User launch Pizzahut application with url")
	public void user_launch_pizzahut_application_with_url() throws IOException {
		 HomePage = launchbrowserUrl();
		 HomePage.goTo();
		 
	}

	

	@Then("User type address as location")
	public void user_type_address_as_location() {
		HomePage.elementToBeDisplay("chen");
	}
	    // Write code here that turns the phrase above into concrete actions
		 
	

	@Given("User see pop up for delivery asking for enter location")
	public void user_see_pop_up_for_delivery_asking_for_enter_location() {
		HomePage.locationpopup();
	}

	@Then("User select first auto populate drop down option")
	public void user_select_first_auto_populate_drop_down_option() {
	 ordersPaage = HomePage.firstdropDown();
		
	}

	@When("User navigate to deails page")
	public void user_navigate_to_deails_page() {
		ordersPaage.ordersPage();
	}

	@Then("User validate vegetarian radio button flag is off")
	public void user_validate_vegetarian_radio_button_flag_is_off() throws InterruptedException {
		Thread.sleep(4000);
		ordersPaage.radiobuton();
	}

	@Then("User clicks on Pizzas menu bar option")
	public void user_clicks_on_pizzas_menu_bar_option() {
		ordersPaage.pizzalink();
	}

	@When("User select add button of any pizza from Recommended")
	public void user_select_add_button_of_any_pizza_from_recommended() {
		ordersPaage.pizzaAddingintoBasket();
	}

	@Then("User see that the pizza is getting added under Your Basket")
	public void user_see_that_the_pizza_is_getting_added_under_your_basket() {
	    // Write code here that turns the phrase above into concrete actions
		ordersPaage.addedItemsInBasket();
		Assert.assertEquals(ordersPaage.addedItemsInBasket(), "4 items");
	}

	@Then("User validate pizza price plus Tax is checkout price")
	public void user_validate_pizza_price_plus_tax_is_checkout_price() {
      ordersPaage.pizzaprices();
      Assert.assertEquals(ordersPaage.totalPrice(), "1436.00");
	  ordersPaage.taxDRopDown();
	}

	@Then("User validate checkout button contains Item count")
	public void user_validate_checkout_button_contains_item_count() {
		ordersPaage.tax();
		Assert.assertEquals(ordersPaage.itemsCountINCheckOut(), "4 items");
			
	}

	@Then("User validate checkout button contains total price count")
	public void user_validate_checkout_button_contains_total_price_count() {
		ordersPaage.pricecount();
	}

	@Then("User clicks on Drinks option")
	public void user_clicks_on_drinks_option() {
		ordersPaage.drinksMenu();
	}

	@Then("User select Pepsi option to add into the Basket")
	public void user_select_pepsi_option_to_add_into_the_basket() {
		ordersPaage.drinkSelection();
	}

	@Then("User see {int} items are showing under checkout button")
	public void user_see_items_are_showing_under_checkout_button(Integer orderpageItem) {
		Assert.assertEquals(ordersPaage.items_totslincheckout(), orderpageItem);
		
	}

	@Then("User see total price is now more than before")
	public void user_see_total_price_is_now_more_than_before() {
		System.out.println(ordersPaage.currentTot());
	}

	@Then("User remove the Pizza item from Basket")
	public void user_remove_the_pizza_item_from_basket() {
		ordersPaage.removefrombasket();
	}

//	@Then("see Price tag got removed from the checkout button")
//	public void see_price_tag_got_removed_from_the_checkout_button() {
//	    ordersPaage.priceTag();
//	}

	@And("User see {int} item showing in checkout button")
	public void user_see_item_showing_in_checkout_button(Integer item) {
		Assert.assertEquals(ordersPaage.itmesinthecheckout(), item);
	}

	@Then("User Clicks on Checkout button")
	public void user_clicks_on_checkout_button() throws InterruptedException {
		ordersPaage.checkout();
	}

	@And("User see minimum order required pop up is getting displayed")
	public void user_see_minimum_order_required_pop_up_is_getting_displayed() {
		ordersPaage.dialogbox();
	}



}
