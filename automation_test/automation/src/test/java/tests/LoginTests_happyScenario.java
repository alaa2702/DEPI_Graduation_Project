package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTests_happyScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	LoginPage loginObject = new LoginPage(driver);
	
	@DataProvider(name="LoginHappyData")
	public Object[][] testData(){		
		Object[][] data = new Object[][] {
			{"abdelrahmanosama7651111@gmail.com","12345678"},
			{"abdelrahmanosama7651@gmail.com","12345678"}
		};
		
		return data;
	}

	
  @Test(priority = 1,dataProvider = "LoginHappyData")
  public void testLogin_CorrectEmailAndPassword(String email,String password) throws InterruptedException {

	homeObject.openLoginPage();

	Assert.assertEquals("Login to your account", loginObject.loginMessage.getText());
	  
	loginObject.userCanLogin(email, password);
	
	Assert.assertEquals("Logout", loginObject.logoutBtn.getText());  
	
	loginObject.userCanLogout();
	
  }
}
