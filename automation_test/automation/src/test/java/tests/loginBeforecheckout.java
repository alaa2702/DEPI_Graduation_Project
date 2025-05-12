package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.CheckOutPage;
import pages.LoginPage;

public class loginBeforecheckout extends TestBase {
	
	HomePage homeObject=new HomePage(driver);
	LoginPage loginobject=new LoginPage(driver);
	CheckOutPage loginBeforecheckoutobject= new CheckOutPage (driver);
	
	
	
  @Test
  public void loginBeforecheckoutsucess() {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  	  Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
		homeObject.openLoginPage(); 
		Assert.assertTrue( loginobject.loginMassage.getText().equalsIgnoreCase("Login to your account"));
		  loginobject.userCanLogin("rawan422@gmail.com", "rawan22");
	  Assert.assertTrue( loginBeforecheckoutobject.logineddmesage.getText().equalsIgnoreCase("Logged in as rawan"));
	  loginBeforecheckoutobject.addorder();
		  loginBeforecheckoutobject.cartOpen();
		  Assert.assertEquals("rgba(255, 165, 0, 1)",loginBeforecheckoutobject.cartBtn.getCssValue("color"));
		  loginBeforecheckoutobject.checkoutopen();
		  Assert.assertTrue( loginBeforecheckoutobject.orderMessage.getText().equalsIgnoreCase("Address Details"));
		  Assert.assertTrue( loginBeforecheckoutobject.reviewMessage.getText().equalsIgnoreCase("Review Your Order"));
		  loginBeforecheckoutobject.leaveMassage("i want it in box");
  loginBeforecheckoutobject.takecardInfo("QNBcard", "2826327329219", "7927439", "7", "2027");
  
  Assert.assertTrue( loginBeforecheckoutobject.successMassage.getText().equalsIgnoreCase("Order Placed!"));
loginBeforecheckoutobject.deleteaccount();
Assert.assertTrue( loginBeforecheckoutobject.deletedMassage.getText().equalsIgnoreCase("Account Deleted!"));

  }
}
