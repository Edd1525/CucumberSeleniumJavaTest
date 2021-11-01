package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage {

	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	@FindBy(how = How.ID, using = "*-best-seller-label")
	private WebElement productBestSeller;

	@FindBy(how = How.ID, using = "add-to-cart-button")
	private WebElement addToCardBtn;


	public void waitForProductsResults() {
		int timeoutToGetResults = 10;
		WebDriverWait wait = new WebDriverWait(driver, timeoutToGetResults);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Best Seller')]")));
	}

	public void selectProductNumber(String number) {
		driver.findElement(By.cssSelector("[data-image-source-density='"+ number +"']")).click();
	}

	public void addProductToCard() {
		this.addToCardBtn.click();
	}
}
