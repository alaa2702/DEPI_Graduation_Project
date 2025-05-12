package tests;

import org.testng.annotations.Test;

import pages.AllProductPage;
import pages.CartPage;
import pages.HomePage;

import org.testng.Assert;

public class RemoveProductFromCart extends TestBase {
  
	AllProductPage allProductPage = new AllProductPage(driver);
	CartPage cartPage = new CartPage(driver);
	HomePage homePage = new HomePage(driver);

  
	@Test
  public void removeProductFromCart () throws InterruptedException{
		Assert.assertEquals(homePage.isHomePageVisible(), "Home page is not visible");
		
		homePage.openProductsPage();
        
        
        allProductPage.scrollDown(600);
        allProductPage.clickFirstAddToCart();
       
        Assert.assertEquals(allProductPage.getAddedModalText(), "Added!", "Product was not added successfully");

       
        allProductPage.clickViewCart();

        String productDesc = cartPage.getProductDescription();
        Assert.assertNotNull(productDesc, "Cart page is not displaying the product");

        cartPage.deleteProduct(0);
    
        Assert.assertFalse(cartPage.isProductInCart(productDesc), "Product was not removed from the cart");
    }
}