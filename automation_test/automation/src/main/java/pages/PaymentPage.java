package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageBase {

	 public PaymentPage(WebDriver driver) {
		 super(driver);
	 }
	 
	 @FindBy(name="name_on_card")
	 public
	 WebElement cardnameTxt;
	 
	 @FindBy(name="card_number")
	 public
	 WebElement cardnumberTxt;
	 
	 @FindBy(name="cvc")
	 public
	 WebElement cvcTxt;
	 
	 @FindBy(name = "expiry_month")
	 public
	 WebElement expiremounthTxt;
	 
	 @FindBy(name = "expiry_year")
	 public
	 WebElement expireyearTxt;
	 
	 @FindBy(id = "submit")
	 public
	 WebElement payBtn;
	 @FindBy(xpath = "//*[@id=\"success_message\"]/div")
	 public WebElement successMessage;	
	 
	 @FindBy(css = "#form > div > div > div > h2 > b")
	 public WebElement OrderSuccessMessage;
	 
	 @FindBy(css = "#form > div > div > div > aa")	
	 public WebElement DownloadInvoiceBtn;
	 
	 @FindBy(css = "#form > div > div > div > div > a")
	 public WebElement continueBtn;
	 
	 public void userCanPay(String cardname, String cardnumber, String cvc, String expiremounth, String expireyear) {
		 cardnameTxt.sendKeys(cardname);
		 cardnumberTxt.sendKeys(cardnumber);
		 cvcTxt.sendKeys(cvc);
		 expiremounthTxt.sendKeys(expiremounth);
		 expireyearTxt.sendKeys(expireyear);
		 payBtn.click();
	 }
	 public String getSuccessMessage() {
		 return successMessage.getText();
	 }
	 public String getOrderSuccessMessage() {
		 return OrderSuccessMessage.getText();
	 }
	 public void downloadInvoice() {
		 DownloadInvoiceBtn.click();
	 }
	 public void continueShopping() {
		 continueBtn.click();
	 }
	 
	 
	 
}
