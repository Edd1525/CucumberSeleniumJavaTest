package runner;
import cucumber.TestContext;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "stepDefinitions",
		snippets = CAMELCASE,
		plugin =  { "pretty",
				"html:target/cucumber-html-report/report.html",
				"json:target/cucumber-reports/cucumber.json"
		},publish = true )
public class TestRunner {
	/*Close the Driver at the end of each scenario*/
	@AfterClass
	public static void closeDriver() {
		TestContext.closeDriver();
	}
}
