package tests;

import java.awt.AWTException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AllProductPage;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

public class SearchProducts_VerifyCartAfterLogin extends TestBase {

	HomePage homeObject = new HomePage(driver);
	LoginPage loginObject = new LoginPage(driver);
	AllProductPage AllProductObject = new AllProductPage(driver);
	CartPage CartPObject = new CartPage(driver);

	@DataProvider(name = "SearchTxt&LoginData")
	public Object[][] testData() {
		Object[][] data = new Object[][] { 
			{ "white","abdelrahmanosama7651111@gmail.com","12345678" } };
		return data;
	}


	@Test(priority = 1, dataProvider = "SearchTxt&LoginData")
	public void testCategoryProducts(String Text1,String email,String password) throws InterruptedException, AWTException {

		homeObject.openProductsPage();
		
		homeObject.scrollDown(200);
		Assert.assertEquals("ALL PRODUCTS", AllProductObject.getPageTitleText());
		AllProductObject.EnterSearchTxt(Text1);
		Thread.sleep(3000);
		
		homeObject.scrollDown(200);
		Assert.assertEquals("SEARCHED PRODUCTS", AllProductObject.getPageTitleText());
		homeObject.scrollDown(300);
		
		List<String> NamesPr = AllProductObject.getAllProductNames();
		for (String name : NamesPr) {
			Assert.assertTrue(name.toLowerCase().contains(Text1), Text1);
		}
		AllProductObject.clickAddToCartForAllProducts();
		Thread.sleep(3000);
		
		NamesPr = AllProductObject.getAllProductNames();
		homeObject.openCartPage();
		homeObject.scrollDown(300);
		List<String> NamesCa1 = CartPObject.getAllProductNames();
		Assert.assertEquals(NamesCa1, NamesPr);
		homeObject.openLoginPage();
		
		Thread.sleep(3000);		  
		loginObject.userCanLogin(email, password);
		
		Assert.assertEquals("Logout", loginObject.logoutBtn.getText());  
		
		Thread.sleep(3000);
		
		homeObject.openCartPage();
		homeObject.scrollDown(300);
		Thread.sleep(3000);
		List<String> NamesCa2 = CartPObject.getAllProductNames();
		
		Assert.assertEquals(NamesCa1, NamesCa2);
		
	}

}
