package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static utility.Waits.clickOn;

public class CartPage {
	WebDriver driver;
	private String quantity;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "nav-cart-count-container")
	private WebElement cartBtn;

	@FindBy(how = How.ID, using = "a-popover-2")
	private WebElement quantityDropdown;

	@FindBy(how = How.ID, using = "a-popover-3")
	private WebElement quantityDropdownReduce;

	@FindBy(how = How.ID, using = "sc-subtotal-label-activecart")
	private WebElement subtotalLabel;

	@FindBy(how = How.CLASS_NAME, using = "sc-action-quantity")
	private WebElement quantityDropdownBtn;

	@FindBy(how = How.CSS, using = ".sc-list-item-content .sc-price")
	private WebElement pricePerProduct;

	@FindBy(how = How.ID, using = "sc-subtotal-amount-activecart")
	private WebElement totalPrice;

	public void goToCart() throws InterruptedException {
		clickOn(driver ,cartBtn);
	}

	public Float getPrice(String quantity) throws InterruptedException {
		String PriceForOneProduct = pricePerProduct.getText();
		return parseInt(quantity) * parseFloat(PriceForOneProduct.replace("$",""));
	}

	public String getNumberItemsSubtotal() {
		return subtotalLabel.getText();
	}

	public String getTotalPrice() throws InterruptedException {
		Thread.sleep(2000);
		return totalPrice.getText().replace("$", "");
	}

	public void setNumberOfProducts(String numberOfProducts) throws InterruptedException {
		clickOn(driver, quantityDropdownBtn);
		quantityDropdown.findElement(By.cssSelector("li[aria-labelledby=quantity_"+ numberOfProducts +"]")).click();
	}

	public void setNumberOfProductsToReduce(String numberOfProducts) throws InterruptedException {
		clickOn(driver, quantityDropdownBtn);
		quantityDropdownReduce.findElement(By.cssSelector("li[aria-labelledby=quantity_"+ numberOfProducts +"]")).click();
	}
}
