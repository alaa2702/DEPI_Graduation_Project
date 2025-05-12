package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ContactUsPage;

import pages.HomePage;

public class ContactUs_happyScenario extends TestBase {
	HomePage homeObject = new HomePage(driver);
	ContactUsPage contactUsObject = new ContactUsPage(driver);
	
   @DataProvider(name="ContactUSData")
	public Object[][] testData(){		
		Object[][] data = new Object[][] {
			{"rawan", "rawan34@gmail.com", "complain", "order not deliver yet"}
		};
		
		return data;
	}
   @DataProvider(name="ContactUSDataWithFile")
  	public Object[][] testDataWithFile(){		
  		Object[][] data = new Object[][] {
  			{"rawan", "rawan34@gmail.com", "complain", "order not deliver yet",System.getProperty("user.dir")+"\\images\\messi.jpg.jpg"}
  		};
  		return data;
  	}
  @Test (priority = 1, dataProvider = "ContactUSData")
  public void testContactUs_validData(String name,String email,String subject,String message) throws InterruptedException, AWTException {
	  homeObject.openContactUsPage();
	  
	  Assert.assertEquals("GET IN TOUCH", contactUsObject.getInMessage.getText());
	  
	  contactUsObject.userCanContactUs(name,email,subject,message);
	  Thread.sleep(3000);
	  
	  Assert.assertEquals("Success! Your details have been submitted successfully.", contactUsObject.successMessage.getText());
  }
  @Test (priority = 2, dataProvider = "ContactUSDataWithFile")
  public void testContactUs_validData(String name,String email,String subject,String message, String filePath) throws InterruptedException, AWTException {
	  homeObject.openContactUsPage();
	  
	  Assert.assertEquals("GET IN TOUCH", contactUsObject.getInMessage.getText());
	  
	  contactUsObject.userCanContactUs(name,email,subject,message, filePath);
	  Thread.sleep(3000);
	  
	  Assert.assertEquals("Success! Your details have been submitted successfully.", contactUsObject.successMessage.getText());
  }
}

