package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class Login_NegativeScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	LoginPage loginObject = new LoginPage(driver);
	
	@DataProvider(name="LoginNegativeData")
	public Object[][] testData(){		
		Object[][] data = new Object[][] {
			{"abdelrahmanosama7651111@gmail.com","123456"},
			{"abdelrahmanosama7659@gmail.com","12345678"}
		};
		
		return data;
	}
	
	 @Test (priority = 1,dataProvider = "LoginNegativeData")
	 public void testLogin_NegativeScenarios(String email,String password) {

		homeObject.openLoginPage();
		
		Assert.assertEquals("Login to your account", loginObject.loginMessage.getText());
		  
		loginObject.userCanLogin(email, password);
		
		Assert.assertEquals("Your email or password is incorrect!", loginObject.failedMessage.getText());
	  }
	
}
