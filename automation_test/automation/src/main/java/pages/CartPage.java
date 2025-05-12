package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase {

	public CartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "div.col-sm-6 > a")
	WebElement checkOutBtn;

	@FindBy(css = "tr.cart_menu td.description")
	WebElement descriptionTitle;

	@FindBy(xpath = "//td[@class='cart_description']/h4/a")
	List<WebElement> productNames;

	@FindBy(xpath = "//td[@class='cart_price']/p")
	List<WebElement> productPrices;

	@FindBy(className = "disabled")
	List<WebElement> productQuantities;

	@FindBy(className = "cart_total_price")
	List<WebElement> productTotalPrices;

	@FindBy(className = "cart_quantity_delete")
	List<WebElement> deleteBtn;
	@FindBy(xpath="//*[@id=\"cart_items\"]/div/div[1]/ol/li[1]/a")
	WebElement homeBtn;
	
	@FindBy(xpath="//*[@id=\"product-1\"]/td[1]/a/img")
	WebElement productImage;
	
	// ======= Utility Methods =======
	public List<String> getAllProductNames() {
		List<String> names = new ArrayList<>();
		for (WebElement name : productNames) {
			names.add(name.getText());
		}
		return names;
	}

	public List<String> getAllProductPrices() {
		List<String> prices = new ArrayList<>();
		for (WebElement price : productPrices) {
			prices.add(price.getText());
		}
		return prices;
	}

	public String ProductQuantitiesTxt(int index) {
		if (index >= 0 && index < productQuantities.size()) {
			return productQuantities.get(index).getText();
		} else {
			return null;
		}
	}

	public String ProductTotalPricesTxt(int index) {
		if (index >= 0 && index < productTotalPrices.size()) {
			return productTotalPrices.get(index).getText();
		} else {
			return null;
		}
	}
	public void DeleteProudctByIndex(int index) {
		if (index >= 0 && index < deleteBtn.size()) {
			deleteBtn.get(index).click();
		}
		
	}
		public void clickCheckout() {
	        checkOutBtn.click();
	    }

	    public void clickHome() {
	        homeBtn.click();
	    }

	    public String getProductDescription() {
	        return descriptionTitle.getText();
	    }
	    
	    public String getQuantity(int index) {
	        return productQuantities.get(index).getText();
	    }

	    public void deleteProduct(int index) {
	        deleteBtn.get(index).click();
	    }
	    
	    

	    public boolean isProductInCart(String productName) {
	        for (WebElement item : productNames) {
	            if (item.getText().contains(productName)) {
	                return true;
	            }
	        }
	        return false;
	    }

		
	}
	

