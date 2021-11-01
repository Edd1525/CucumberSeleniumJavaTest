package cucumber;

import managers.DriverManager;
import managers.PageObjectManager;

public class TestContext {
	private DriverManager drivermanager;
	private PageObjectManager pageObjectManager;

	public TestContext() {
		drivermanager = new DriverManager();
	}

	public static void closeDriver() {
		DriverManager.closeDriver();
	}

	public PageObjectManager getPageObjectManager() {
		pageObjectManager = new PageObjectManager(drivermanager.getDriver());
		return pageObjectManager;
	}
}
