package CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", glue = { "StepDefination", "Utilities" }, plugin = { "pretty",
		"html:target/cucumber/", "json:target/report/cucumber.json",
		"junit:target/report/cucumber.xml" }, monochrome = true)
public class TestRunner {

}
