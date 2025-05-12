package tests;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AllProductPage;
import pages.CartPage;
import pages.HomePage;

public class AddProductsinCart extends TestBase {

	HomePage homeObject = new HomePage(driver);
	AllProductPage AllProductObject = new AllProductPage(driver);
	CartPage CartPObject = new CartPage(driver);

	@DataProvider(name = "AddIndex")
	public Object[][] testData() {
		Object[][] data = new Object[][] { { 0, 1 } };

		return data;
	}

	@Test(priority = 1, dataProvider = "AddIndex")
	public void testAddProducts(int index1, int index2) throws InterruptedException, AWTException {

		Assert.assertEquals("FEATURES ITEMS", AllProductObject.getPageTitleText());
		homeObject.openProductsPage();
		List<String> NamesPr = new ArrayList<>();
		List<String> PricesPr = new ArrayList<>();

		homeObject.scrollDown(600);

		NamesPr.add(AllProductObject.getProductNameByIndex(index1));
		PricesPr.add(AllProductObject.getProductPricesByIndex(index1));
		AllProductObject.clickFirstAddToCart();
		AllProductObject.clickContinueShopping();
		Thread.sleep(3000);

		homeObject.scrollDown(200);
		NamesPr.add(AllProductObject.getProductNameByIndex(index2));
		PricesPr.add(AllProductObject.getProductPricesByIndex(index2));
		AllProductObject.clickAddToCartByIndex(index2);
		AllProductObject.clickViewCart();
		Thread.sleep(3000);

		// Cart
		List<String> NamesCa = CartPObject.getAllProductNames();
		List<String> PricesCa = CartPObject.getAllProductPrices();
		Assert.assertEquals(NamesCa, NamesPr);
		Assert.assertEquals(PricesCa, PricesPr);
		Assert.assertEquals(CartPObject.ProductQuantitiesTxt(index1), "1");
		Assert.assertEquals(CartPObject.ProductQuantitiesTxt(index2), "1");
		Assert.assertEquals(CartPObject.ProductTotalPricesTxt(index1), PricesCa.get(index1));
		Assert.assertEquals(CartPObject.ProductTotalPricesTxt(index2), PricesCa.get(index2));

	}
}
