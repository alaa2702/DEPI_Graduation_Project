package tests;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;
import pages.registerBeforeCheckoutPage;

public class registerBeforeCheckout extends TestBase {
	
	HomePage homeObject=new HomePage(driver);
	RegisterPage Registerobject=new RegisterPage(driver);
	registerBeforeCheckoutPage registerBeforeCheckoutPageobject=new registerBeforeCheckoutPage(driver);
	
  @Test
  public void registerBeforeCheckoutsucess() {
	  

		Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
		
		String name="rawan";
	  homeObject.RegisterationOpen();
	  Assert.assertEquals("New User Signup!", Registerobject.newUsermassage.getText());

	  Registerobject.UserCanRegister(name,"rawan898@gmail.com");
	  
	  Assert.assertTrue( Registerobject.EnterAccountMassage.getText().equalsIgnoreCase("ENTER ACCOUNT INFORMATION"));
	  Registerobject.enterAccountInformation("rawan5667899","21","5","2005","rawan","mohamed","google","dokki","hadayk","56443","012887386844");
	  
	  Assert.assertTrue( Registerobject.successMassage.getText().equalsIgnoreCase("Account Created!"));
	  Registerobject.continueAccount();
	
	  Assert.assertEquals("Logged in as "+name, Registerobject.loggedIntxt.getText());
	  
	  registerBeforeCheckoutPageobject.addorder();
	  
	  registerBeforeCheckoutPageobject.cartOpen();
	  Assert.assertEquals("rgba(255, 165, 0, 1)",registerBeforeCheckoutPageobject.cartBtn.getCssValue("color"));
	  registerBeforeCheckoutPageobject.checkoutopen();
	  Assert.assertTrue( registerBeforeCheckoutPageobject.orderMessage.getText().equalsIgnoreCase("Address Details"));
	  Assert.assertTrue( registerBeforeCheckoutPageobject.reviewMessage.getText().equalsIgnoreCase("Review Your Order"));
	  registerBeforeCheckoutPageobject.leaveMassage("i want it in box");
	  registerBeforeCheckoutPageobject.takecardInfo("QNBcard", "2826327329219", "7927439", "7", "2027");

Assert.assertTrue( registerBeforeCheckoutPageobject.successMassage.getText().equalsIgnoreCase("Order Placed!"));
registerBeforeCheckoutPageobject.deleteaccount();
Assert.assertTrue( registerBeforeCheckoutPageobject.deletedMassage.getText().equalsIgnoreCase("Account Deleted!"));

	  
  }
}
