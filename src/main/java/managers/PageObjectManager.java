package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductDetailPage;

public class PageObjectManager {

	private final WebDriver driver;
	private CartPage cartPage;
	private HomePage homePage;
	private ProductDetailPage productDetailPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	public ProductDetailPage getProductDetailPage() {
		return(productDetailPage==null)? productDetailPage = new ProductDetailPage(driver) : productDetailPage;
	}
	public HomePage getHomePage() {
		return(homePage==null)? homePage = new HomePage(driver) : homePage;
	}
	public CartPage getCartPage() {
		return(cartPage==null)? cartPage = new CartPage(driver) : cartPage;
	}
}
