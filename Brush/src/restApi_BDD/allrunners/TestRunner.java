package restApi_BDD.allrunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
		features = "src/restApi_BDD.resources",
        glue = {"src/restApi_BDD.stepDefinitions"},
        monochrome = true,
        strict = true
)
	public class TestRunner {
		 
	}
