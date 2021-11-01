package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.ProductDetailPage;

public class ProductDetailsSteps {
	CartPage cartPage;
	ProductDetailPage productDetailPage;
	TestContext testContext;
	public ProductDetailsSteps(TestContext context) {
		testContext = context;
		cartPage = testContext.getPageObjectManager().getCartPage();
		productDetailPage = testContext.getPageObjectManager().getProductDetailPage();
	}

	@When("^the user Add the first (.*) with (.*) to the cart$")
	public void theUserAddTheFirsItem(String item, String quantity) throws InterruptedException {
		productDetailPage.selectProductNumber(item);
		productDetailPage.addProductToCard();
		cartPage.goToCart();
		cartPage.setNumberOfProducts(quantity);
	}
}
