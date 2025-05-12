package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AllProductPage;
import pages.HomePage;

public class ViewCategoryProducts  extends TestBase {
	HomePage homeObject = new HomePage(driver);
	AllProductPage AllProductObject = new AllProductPage(driver);
	
	@DataProvider(name="CategoryIndex")
	public Object[][] testData(){		
		Object[][] data = new Object[][] {
			{0,1,1,1}
		};
		
		return data;
	}
	 @Test(priority = 1, dataProvider = "CategoryIndex")
	  public void testCategoryProducts(int index1,int index2,int index3,int index4) throws InterruptedException, AWTException {
		  homeObject.openProductsPage();
		  
		  Assert.assertEquals("CATEGORY", AllProductObject.getCategoriesTitleText());
		  
		  homeObject.scrollDown(500);
		  AllProductObject.clickSubCategoryByIndex(index1, index2);
		  Thread.sleep(3000);
		  
			Assert.assertEquals("WOMEN - TOPS PRODUCTS", AllProductObject.getPageTitleText());
		  
		  homeObject.scrollDown(200);		  
		  AllProductObject.clickSubCategoryByIndex(index3, index4);
		  Thread.sleep(3000);
		  
		  Assert.assertEquals("MEN -  JEANS PRODUCTS", AllProductObject.getPageTitleText());
	  }
}
