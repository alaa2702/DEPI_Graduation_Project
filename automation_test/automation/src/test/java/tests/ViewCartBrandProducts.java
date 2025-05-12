package tests;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AllProductPage;
import pages.HomePage;

public class ViewCartBrandProducts extends TestBase {
	HomePage homeObject = new HomePage(driver);
	AllProductPage AllProductObject = new AllProductPage(driver);

	@DataProvider(name = "BrandIndex")
	public Object[][] testData() {
		Object[][] data = new Object[][] { { 2, 5 } };

		return data;
	}

	@Test(priority = 1, dataProvider = "BrandIndex")
	public void testBrandsProducts(int index1, int index2) throws InterruptedException, AWTException {
		homeObject.openProductsPage();
		homeObject.scrollDown(500);

		Assert.assertEquals("BRANDS", AllProductObject.getBrandsTitleText());
		AllProductObject.clickBrandsByIndex(index1);
		Thread.sleep(3000);

		Assert.assertEquals("BRAND - MADAME PRODUCTS", AllProductObject.getPageTitleText());
		homeObject.scrollDown(500);
		AllProductObject.clickBrandsByIndex(index2);
		Thread.sleep(3000);

		Assert.assertEquals("BRAND - ALLEN SOLLY JUNIOR PRODUCTS", AllProductObject.getPageTitleText());
	}
}
