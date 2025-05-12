package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AllProductPage;
import pages.CartPage;
import pages.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VerifyProductQuantityInCartTest extends TestBase {

	 AllProductPage allProductPage = new AllProductPage(driver);
	 	CartPage cartPage = new CartPage(driver);
	 	HomePage homePage = new HomePage(driver);

    @Test
    public void verifyProductQuantityInCart() throws InterruptedException {

        
        Assert.assertEquals(homePage.isHomePageVisible(), "Home page is not visible");

        
       
        allProductPage.scrollDown(1000);
       
        allProductPage.clickViewProductsByIndex(0);

     
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/product_details/"), "Product detail page not opened");

        WebElement quantityInput = driver.findElement(By.id("quantity"));
        quantityInput.clear();
        quantityInput.sendKeys("4");

        WebElement addToCartBtn = driver.findElement(By.cssSelector("button[type='button'].cart"));
        addToCartBtn.click();

        Thread.sleep(1000);

        allProductPage.clickViewCart();

        String actualQuantity = cartPage.getQuantity(0);
        Assert.assertEquals(actualQuantity, "4", "Product quantity in cart is incorrect");
    }
}