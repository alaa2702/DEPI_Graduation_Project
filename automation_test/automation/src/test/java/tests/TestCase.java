package tests;

import org.testng.Assert;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.testCasesPage;



public class TestCase extends TestBase{
	
	HomePage homeObject = new HomePage(driver);
	testCasesPage testcaseobject =new testCasesPage(driver);
	
	
  @Test
  public void openTestCasePageCorrect() {
	  Assert.assertEquals("rgba(255, 165, 0, 1)",homeObject.homeLink.getCssValue("color"));
	  
	  homeObject.openTestCasesPage();
	  Assert.assertTrue(testcaseobject.testCaseMesage.getText().equalsIgnoreCase("Test Cases"));
	  
  }
}
