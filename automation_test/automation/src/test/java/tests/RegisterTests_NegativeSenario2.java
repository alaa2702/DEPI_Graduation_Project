package tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;




public class RegisterTests_NegativeSenario2 extends TestBase{

	HomePage homeObject=new HomePage(driver);
	RegisterPage Registerobject=new RegisterPage(driver);

	
  @Test(priority=1)
  public void TestRegisterationMandatoryAndoptional() throws InterruptedException {
	  
		Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
		
		String name="rawan2";
	  homeObject.openRegisterationPage();
	  Assert.assertEquals("New User Signup!", Registerobject.newUserMessage.getText());

	  Registerobject.userCanRegister(name,"Rawksl@gmail.com");
	  
	  Assert.assertTrue( Registerobject.enterAccountMessage.getText().equalsIgnoreCase("ENTER ACCOUNT INFORMATION"));
	  Registerobject.enterAccountInformation("rawan5667899", 21, "5", "2005", "rawan2",
			  "mohamed", "google", "dokki", "Canada", "Giza", "hadayk", "56443", "012887386844");
	  
	  Assert.assertTrue( Registerobject.successMessage.getText().equalsIgnoreCase("Account Created!"));
	  Registerobject.continueAccount();
	
	  Assert.assertEquals("Logged in as "+name, Registerobject.loggedInLink.getText());
	  Registerobject.deleteAccount();
	  
	  Assert.assertTrue( Registerobject.deleteMessage.getText().equalsIgnoreCase("Account Deleted!"));
	  Registerobject.continueAccount();
  }


}
