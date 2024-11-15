package pric;

import org.testng.annotations.Test;
import java.io.IOException;

import pageObjects.HomePage;
import pageObjects.Landing_Page;
import pageObjects.deletelockedmessage;
import utils.Baseclass;

public class LockedMessageFlow extends Baseclass{
	
	
	@Test
		public void endtoend() throws IOException, Exception {
		
		HomePage HomePage = new HomePage(driver);
		//login page
		HomePage.login_contactnum();
		HomePage.sendOtp();
		Thread.sleep(15000);
		HomePage.verifyOtp();
		Thread.sleep(5000);
		//landing page
		HomePage.locked_message();
		Landing_Page Landing_page = new Landing_Page(driver);
		//creatimg locked message
		Landing_page.createLockMessage();
		Landing_page.enterAmount("20");
		Thread.sleep(3000);
		Landing_page.visibleMessages("unique");
		Landing_page.nextButton();
		Landing_page.premium_content();
		Landing_page.submit();
		Thread.sleep(5000);
		HomePage.locked_message();
		Thread.sleep(2000);
		//Scenario 2.View_locked_message 
		
		Landing_page.read_locked_message();
		Thread.sleep(3000);
		HomePage.locked_message();
		Thread.sleep(3000);
		//scenario 2 edit locked message
		Landing_page.edit_locked_message();
		Landing_page.clear_amount();
		Landing_page.enterAmount("22");
		   int i =0;
		   while(i<2) {
	          Landing_page.submit(); 
	           i++;
	           }
		   //scenario 3 delete locked message
		   deletelockedmessage deletelockedmessage = new deletelockedmessage(driver);
		   deletelockedmessage.delete_locked_message();
		   deletelockedmessage.deletePermanently();
		   
		}
}


