package tests;

import org.testng.annotations.Test;


import pages.HomePage;
import pages.RegisterPage;

import org.testng.Assert;

public class RegisterTests_negativeScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	RegisterPage registerObject= new RegisterPage(driver);
	
    @Test (priority = 3)
    public void testRegister_ExistEmail() throws InterruptedException {
    	Assert.assertEquals("rgb(255, 165, 0)",homeObject.homeLink.getCssValue("color"));
    	
    	homeObject.openRegisterationPage();
    	
    	
    	Assert.assertEquals("New User Signup!", registerObject.newUserMessage.getText());
    	
    	String name ="Mohamed Ahmed";
    	registerObject.userCanRegister(name,"abdelrahmanosama7651111@gmail.com");
    
    	
    	Assert.assertEquals("Email Address already exist!", registerObject.failedMessage.getText());
    	
    }
    
   
}
