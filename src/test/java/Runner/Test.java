package Runner;

import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import Utilities.UtilitiesBase;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", glue = { "StepDefinitions" }, plugin = { "pretty",
		"json:target/cucumber.json", "junit:target/cucumber.xml" },
		tags="@current-implementation")

public class Test {
	@AfterClass
	public static void clean() {
		List<String> jsonFiles = new ArrayList();
		String path = System.getProperty("user.dir") + "/target/cucumber.json";
		jsonFiles.add(path);

		UtilitiesBase.generateReport("Test Report", jsonFiles);
	}
}