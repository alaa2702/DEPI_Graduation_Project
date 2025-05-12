package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Signup / Login")
	WebElement signUpBtn;
	@FindBy(linkText = "Home")
	public WebElement homeLink;
	@FindBy(linkText = "Contact us")
	WebElement contactUsBtn;
	@FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")
	public WebElement logineddmesage;
    @FindBy(linkText = "Logout")
    public WebElement logoutBtn;
    @FindBy(linkText = "Test Cases")
    public WebElement testCasesBtn;
    @FindBy(css = "a[href='/products']")
    public WebElement productsBtn;
    @FindBy(linkText = "Cart")
    public WebElement cartBtn;
    @FindBy(linkText = "Delete Account")
    public WebElement deleteBtn;
     @FindBy(id = "susbscribe_email")
     public WebElement susbscribe_email;
     @FindBy(id = "subscribe")
     public WebElement subscribeBtn;
    
	public void openRegisterationPage() {
		signUpBtn.click();
	}
	
	public void openLoginPage() {
		signUpBtn.click();
	}
	
	public void openContactUsPage() {
		contactUsBtn.click();
	}
	
	public void openHomePage() {
		homeLink.click();
	}
    	public void logOut() {
		logoutBtn.click();
	}
    		public void openTestCasesPage() {
		testCasesBtn.click();
	}
    			public void openProductsPage() {
		productsBtn.click();
	}
    public void openCartPage() {
		cartBtn.click();
	}
    public void openDeleteAccountPage() {
		deleteBtn.click();
	}
    
    public void susbscribe_email(String email) {
		susbscribe_email.sendKeys(email);
	}
	public void clickSubscribeBtn() {
		subscribeBtn.click();
	}
	
    public void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

	public String isHomePageVisible() {
		// TODO Auto-generated method stub
		return "Home page is not visible";
	}
    	
}
