package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;


import org.testng.annotations.DataProvider;
import org.testng.Assert;


public class RegisterTests_happyScenario extends TestBase{
	HomePage homeObject = new HomePage(driver);
	RegisterPage registerObject = new RegisterPage(driver);
	
	@DataProvider(name="registerTestData")
	public Object[][] userData() {
		Object testData [][] = new Object[][] {
			{"Abdelrahman Osama","abdelrahmanosama768512@gmail.com","123456789",25,"12","2002","Abdelrahman","Osama","Itworx","Fostat","India","aaaa","bbbb","17622","01013440554","Success"},
			{"Mohamed ahmed","abdelrahmanosama768512@gmail.com","1011121314",30,"10","2004","Mohamed","Ahmed","Valeo","ElDokki","United States","dddd","cccc","17623","01156254596","Failed"},
			{"Mostafa Khaled","abdelrahmanosama768512@gmail.com","1011121314",30,"11","2004","Mohamed","Ahmed","Valeo","ElDokki","United States","dddd","cccc","18623","01256254596","Success"},
		};
		return testData;
	}
	
    @Test (priority = 1,dataProvider = "registerTestData")
    public void testRegister_NewEmail_MandarotyAndOptional(String name,String email,String password,int day
    		,String month,String year,String firstName,
    		String lastName,String company,String address1,
    		String country,String state,String city,
    		String zipCode,String mobileNumber, String expectedResult
    		) throws InterruptedException {
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	
    	homeObject.openRegisterationPage();
    	
    	Assert.assertEquals("New User Signup!", registerObject.newUserMessage.getText());
    	

    	registerObject.userCanRegister(name,email);
    	
    	Assert.assertEquals("ENTER ACCOUNT INFORMATION", registerObject.enterAccountMessage.getText());///الطريقة الاولي
    	
    	registerObject.enterAccountInformation(password,day,month,year,
    			firstName,lastName,company,address1,
    			country,state,city,zipCode,mobileNumber);
    	
    	Assert.assertTrue(registerObject.successMessage.getText().equalsIgnoreCase("Account Created!"));/// الطريقة الثانية
    	
    	registerObject.continueAccount();
    	Assert.assertEquals("Logged in as "+name, registerObject.loggedInLink.getText());
    	
    	registerObject.deleteAccount();

    	String deleteText = "Account Deleted!";
    	Assert.assertEquals(deleteText.toUpperCase(), registerObject.deleteMessage.getText());/// الطريقة الثالثة
    	
    	registerObject.continueAccount();
    }
    
    @Test (priority = 2,dependsOnMethods = {"testRegister_NewEmail_MandarotyAndOptional"})
    public void testRegister_NewEmail_Mandaroty() throws InterruptedException {
    	Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
    	
    	homeObject.openRegisterationPage();
    	
    	Assert.assertEquals("New User Signup!", registerObject.newUserMessage.getText());
    	
    	String name ="Mohamed Ahmed";
    	registerObject.userCanRegister(name,"abdelrahmanosama76833@gmail.com");
    	
    	Assert.assertEquals("ENTER ACCOUNT INFORMATION", registerObject.enterAccountMessage.getText());///الطريقة الاولي
    	
    	registerObject.enterAccountInformation("123456789",1,"12","2002",
    			"Abdelrahman","Osama","","Fostat",
    			"United States","Newyork","aaaa","17611",
    			"01013440554"
    			);
    	
    	
    	Assert.assertTrue(registerObject.successMessage.getText().equalsIgnoreCase("Account Created!"));/// الطريقة الثانية
    	
    	registerObject.continueAccount();
    	Assert.assertEquals("Logged in as "+name, registerObject.loggedInLink.getText());
    	
    	registerObject.deleteAccount();

    	String deleteText = "Account Deleted!";
    	Assert.assertEquals(deleteText.toUpperCase(), registerObject.deleteMessage.getText());//الطريقة الثالثة
    	
    	registerObject.continueAccount();
    }

}
