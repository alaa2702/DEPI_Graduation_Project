package pages;

import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProductPage extends PageBase {

	public AllProductPage(WebDriver driver) {
		super(driver);
	}

	// ======= Locators =======
	// Search
	@FindBy(id = "search_product")
	WebElement searchTxt;
	@FindBy(id = "submit_search")
	WebElement searchBtn;

	// Title text
	@FindBy(css = ".title.text-center")
	public WebElement pageTitle;
	@FindBy(css = ".left-sidebar > h2")
	public WebElement categoriesTitle;
	@FindBy(css = ".brands_products > h2")
	public WebElement brandsTitle;

	// Category
	@FindBy(css = ".panel-title a")
	List<WebElement> mainCategories;

	// (Women -> Dress, Tops, Saree)
	@FindBy(xpath = "//div[@id='Women']//a")
	List<WebElement> womenSubCategories;
	// (Men -> Tshirts, Jeans)
	@FindBy(xpath = "//div[@id='Men']//a")
	List<WebElement> menSubCategories;
	// (Kids -> Dress, Tops&Shirts)
	@FindBy(xpath = "//div[@id='Kids']//a")
	List<WebElement> kidsSubCategories;

	// Brands
	@FindBy(css = ".brands-name li a")
	List<WebElement> brandLinks;

	// Product Info
	@FindBy(css = "div.product-image-wrapper")
	List<WebElement> allProducts;
	@FindBy(className = "productinfo")
	List<WebElement> productElements;
	@FindBy(css = "div.productinfo.text-center > h2")
	List<WebElement> productPrices;
	@FindBy(css = "div.productinfo.text-center p")
	List<WebElement> productNames;
	@FindBy(xpath = "//div[@class='productinfo text-center']//a[contains(@class, 'add-to-cart')]")
	List<WebElement> addToCartBtn;
	@FindBy(css = "div.choose ul.nav-pills li a[href^='/product_details/']")
	List<WebElement> viewProductBtn;

	// After add to cart
	@FindBy(css = ".modal-title.w-100")
	WebElement addedTxt;
	@FindBy(css = "p.text-center a[href='/view_cart']")
	WebElement viewCartBtn;
	@FindBy(css = "button.btn-success.close-modal")
	WebElement continueShoppingBtn;

	// Scroll Up
	@FindBy(id = "scrollUp")
	WebElement scrollUpBtn;

	// ======= Utility Methods =======

	public void EnterSearchTxt(String text) {
		searchTxt.clear();
		searchTxt.sendKeys(text);
		searchBtn.click();
	}

	// get Title Text
	public String getPageTitleText() {
		return pageTitle.getText();
	}

	public String getCategoriesTitleText() {
		return categoriesTitle.getText();
	}

	public String getBrandsTitleText() {
		return brandsTitle.getText();
	}

	// Names
	public String getProductNameByIndex(int index) {
		if (index >= 0 && index < productNames.size()) {
			return productNames.get(index).getText();
		} else {
			return null;
		}
	}

	public List<String> getAllProductNames() {
		List<String> names = new ArrayList<>();
		for (WebElement name : productNames) {
			names.add(name.getText());
		}
		return names;
	}

	// prices
	public String getProductPricesByIndex(int index) {
		if (index >= 0 && index < productPrices.size()) {
			return productPrices.get(index).getText();
		} else {
			return null;
		}
	}

	public List<String> getAllProductPrices() {
		List<String> prices = new ArrayList<>();
		for (WebElement price : productPrices) {
			prices.add(price.getText());
		}
		return prices;
	}

	// click
	public void clickFirstAddToCart() {
		if (!addToCartBtn.isEmpty()) {
			addToCartBtn.get(0).click();
		}
	}

	public void clickAddToCartByIndex(int index) {
		if (index >= 0 && index < addToCartBtn.size()) {
			addToCartBtn.get(index).click();
		}
	}
	public void clickAddToCartForAllProducts() {
	    for (WebElement btn : addToCartBtn) {
	        btn.click();
	        continueShoppingBtn.click();
	    }
	}


	public void clickViewProductsByIndex(int index) {
		if (index >= 0 && index < viewProductBtn.size()) {
			viewProductBtn.get(index).click();
		}
	}

	public void clickScrollUp() {
		scrollUpBtn.click();
	}

	// After add to cart
	public void clickViewCart() {
		viewCartBtn.click();
	}

	public void clickContinueShopping() {
		continueShoppingBtn.click();
	}

	public String getAddedModalText() {
		return addedTxt.getText();
	}

	// Main & Sub Category click
	public void clickMainCategoryByIndex(int index) {
		if (index >= 0 && index < mainCategories.size()) {
			mainCategories.get(index).click();
		}
	}

	public void clickSubCategoryByIndex(int mainIndex, int subIndex) {
		List<WebElement> subCategories = null;
		switch (mainIndex) {
		case 0:
			clickMainCategoryByIndex(mainIndex);
			subCategories = womenSubCategories;
			break;
		case 1:
			clickMainCategoryByIndex(mainIndex);
			subCategories = menSubCategories;
			break;
		case 2:
			clickMainCategoryByIndex(mainIndex);
			subCategories = kidsSubCategories;
			break;
		}
		if (subIndex >= 0 && subIndex < subCategories.size()) {
			subCategories.get(subIndex).click();
		}
	}

	// Brands click
	public void clickBrandsByIndex(int index) {
		if (index >= 0 && index < brandLinks.size()) {
			brandLinks.get(index).click();
		}
	}
	// Scroll
  	public void scrollDown(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// arguments[0] is your 'pixels' int, so no string formatting or hidden chars needed
		js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
	}

	public void scrollUp(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// arguments[0] is your 'pixels' int, so no string formatting or hidden chars needed
		js.executeScript("window.scrollBy(0, -arguments[0]);", pixels);
	}

}
