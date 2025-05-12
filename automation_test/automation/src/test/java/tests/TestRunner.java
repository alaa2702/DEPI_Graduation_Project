package tests;

import org.testng.TestNG;

public class TestRunner {

    public static void main(String[] args) {
        TestNG testng = new TestNG();

        // List all your @Test-annotated classes here:
        Class<?>[] testClasses = {
            AddProductsinCart.class,
            ContactUs_happyScenario.class,
            Login_NegativeScenario.class,
          //  loginBeforeCheckout.class,
            LoginTests_happyScenario.class,
            LogOutScenario.class,
          //  registerBeforeCheckout.class,
            RegisterTests_happyScenario.class,
            RegisterTests_negativeScenario.class,
            RegisterWithExistingEmailScenario.class,
            RemoveProductFromCart.class,
            SearchProducts_VerifyCartAfterLogin.class,
            SubscriptionTest.class,
            // You can include TestBase/TestCase too if they have @Test methods:
        
            TestCase.class,
            VerifyProductQuantityInCartTest.class,
            ViewCartBrandProducts.class,
            ViewCategoryProducts.class
        };

        // Tell TestNG to run them:
        testng.setTestClasses(testClasses);
        testng.run();
    }
}
