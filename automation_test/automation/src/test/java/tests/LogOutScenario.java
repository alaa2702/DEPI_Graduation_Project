package tests;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LogOutScenario extends TestBase {
    HomePage homeObject = new HomePage(driver);
    LoginPage loginObject = new LoginPage(driver);

    @DataProvider(name = "ValidLoginData")
    public Object[][] loginData() {
        return new Object[][] {
            {"alaa27122002@gmail.com", "Mooody@2003", "Alaa"}
        };
    }

    @Test(priority = 1, dataProvider = "ValidLoginData")
    public void testLoginAndLogout(String email, String password, String username) {

        // Step 1–3: Verify home page is visible
        Assert.assertEquals("rgb(255, 165, 0)", homeObject.homeLink.getCssValue("color"));

        // Step 4: Click on 'Signup / Login'
        homeObject.openLoginPage();

        // Step 5: Verify login form is visible
        Assert.assertEquals(loginObject.loginMessage.getText(), "Login to your account");

        // Step 6: Enter correct email/password
        loginObject.userCanLogin(email, password);

        // Step 7–8: Verify 'Logged in as username'
        Assert.assertTrue(homeObject.logineddmesage.getText().contains("Logged in as " + username));

        // Step 9: Click Logout
        homeObject.logOut();

        // Step 10: Verify redirected to login page
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/login");
    }
}
