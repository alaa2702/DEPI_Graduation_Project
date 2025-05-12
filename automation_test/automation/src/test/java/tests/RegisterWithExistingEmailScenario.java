package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;

import pages.RegisterPage;

public class RegisterWithExistingEmailScenario extends TestBase {
    HomePage homeObject = new HomePage(driver);
    RegisterPage registerObject = new RegisterPage(driver);

    @DataProvider(name = "ExistingUserData")
    public Object[][] existingUserData() {
        return new Object[][] {
            {"Alaa", "alaa27122002@gmail.com"} // make sure this email is already registered
        };
    }

    @Test(priority = 1, dataProvider = "ExistingUserData")
    public void testSignupWithExistingEmail(String name, String email) {
        // Step 3: Assert home page visible
        Assert.assertEquals("rgb(255, 165, 0)", homeObject.homeLink.getCssValue("color"));

        // Step 4: Open Signup/Login page
        homeObject.openLoginPage();

        // Step 5: Check "New User Signup!" is visible
        Assert.assertEquals(registerObject.newUserMessage.getText(), "New User Signup!");
        // Step 6–7: Attempt to sign up with existing email
        registerObject.userCanRegister(name, email);

        // Step 8: Assert "Email Address already exist!" error appears
        Assert.assertTrue(registerObject.failedMessage.getText().contains("Email Address already exist!"));
        
}
    }
