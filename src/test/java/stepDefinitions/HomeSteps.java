package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import pageObjects.HomePage;
import pageObjects.ProductDetailPage;

public class HomeSteps {
	HomePage homePage;
	TestContext testContext;
	ProductDetailPage productDetailPage;

	public HomeSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		productDetailPage = testContext.getPageObjectManager().getProductDetailPage();
	}

	@Given("The user is on the amazon page")
	public void theUserIsOnTheAmazonPage() {
		homePage.navigateTo_HomePage();
	}

	@Given("^the user Search for (.*)$")
	public void theUserSearchFor(String item) throws InterruptedException {
		homePage.perform_Search(item);
		productDetailPage.waitForProductsResults();
	}
}
