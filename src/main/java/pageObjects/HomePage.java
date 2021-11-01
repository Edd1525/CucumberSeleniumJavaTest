package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how= How.ID, using="twotabsearchtextbox")
	private WebElement searchInput;

	@FindBy(how= How.ID, using="nav-search-submit-button")
	private WebElement searchSubmit;

	WebDriver driver;

	public void perform_Search(String item) throws InterruptedException {
		searchInput.sendKeys(item);
		searchSubmit.click();
	}
	
	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl());
	}
}
