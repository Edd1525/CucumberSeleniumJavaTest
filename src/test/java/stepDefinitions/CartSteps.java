package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.CoreMatchers;
import pageObjects.CartPage;
import pageObjects.ProductDetailPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CartSteps {
	TestContext testContext;
	ProductDetailPage productListingPage;
	CartPage cartPage;

	public CartSteps(TestContext context) {
		testContext = context;
		productListingPage = testContext.getPageObjectManager().getProductDetailPage();
		cartPage = testContext.getPageObjectManager().getCartPage();
	}

	@When("^the user reduce the quantity of items to (.*)$")
	public void theUserReduceTheQuantityOfItemsTo(String quantityReduce) throws InterruptedException {
		cartPage.setNumberOfProductsToReduce(quantityReduce);
	}

	@Then("^the total price and quantity (.*) are correct$")
	public void theTotalPriceAndQuantityAreCorrect(String quantity) throws InterruptedException {
		Float totalValueItems = cartPage.getPrice(quantity);
		Float totalPrice = Float.valueOf(cartPage.getTotalPrice());
		String numberOfItemsSubtotalMessage = cartPage.getNumberItemsSubtotal();

		assertThat(totalValueItems, comparesEqualTo(totalPrice));
		assertThat(numberOfItemsSubtotalMessage,CoreMatchers.containsString("Subtotal ("+ quantity +""));
	}
}
