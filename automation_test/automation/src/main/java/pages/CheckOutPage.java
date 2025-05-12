package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageBase{

	 public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	 
	 
	 @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[2]/h2")
	 public
	 WebElement AddressMessage;
	 
	 @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[4]/h2")
	 public
	 WebElement  reviewMessage;
	 
	 @FindBy(name = "message")
	 public
	 WebElement  descriptionTxt;
	
	 
	 @FindBy(xpath = "//*[@id=\"cart_items\"]/div/div[7]/a")
	 public
	 WebElement  placeorderBtn;
	 

	 
	 @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
	 public
	 WebElement successMassage;
	 

	 @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
	 public
	 WebElement deletedMassage;
	 
	 @FindBy(xpath  = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
	 public
	 WebElement productBtn;
	 
	 @FindBy(xpath = "//div[@class='productinfo text-center']//a[contains(text(),'Add to cart')]")
	 public
	 WebElement addproduct;
	 
	 @FindBy(xpath="//*[@id=\"cartModal\"]/div/div/div[3]/button")
	 public
	 WebElement continueBtn;
	 
	 public void addorder() {
		productBtn.click();
		addproduct.click();
		continueBtn.click();
	}
	 
	
	 
	 public void leaveMassage(String massage) {
		descriptionTxt.sendKeys(massage);
		placeorderBtn.click();
		
	}
	 


}
