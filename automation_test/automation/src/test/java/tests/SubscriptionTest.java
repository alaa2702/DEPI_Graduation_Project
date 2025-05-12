package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;

public class SubscriptionTest extends TestBase {
    HomePage homeObject = new HomePage(driver);

    @DataProvider(name = "subscriptionEmails")
    public Object[][] subscriptionData() {
        return new Object[][] {
            {"testuser1@example.com"},
            {"demo123@example.com"},
            {"subscriber456@example.com"}
        };
    }
    

    @Test(priority = 1, dataProvider = "subscriptionEmails")
    public void testSubscriptionFooter(String email) throws InterruptedException {
        // Step 1: Verify home page is visible successfully
        Assert.assertEquals("rgb(255, 165, 0)", homeObject.homeLink.getCssValue("color"));

        // Step 2: Scroll down to footer
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000); // allow time for footer to be fully loaded

        // Step 3: Verify 'SUBSCRIPTION' text is visible
        WebElement subscriptionText = driver.findElement(By.xpath("//*[contains(text(),'Subscription')]"));
        Assert.assertTrue(subscriptionText.isDisplayed(), "'SUBSCRIPTION' text is not visible");

        // Step 4: Enter email and click arrow
        homeObject.susbscribe_email(email);
        homeObject.clickSubscribeBtn();
        Thread.sleep(2000); // wait for response

        // Step 5: Verify success message
        WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(),'You have been successfully subscribed!')]"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message not displayed for email: " + email);
    }
}
