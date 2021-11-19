package webAutomation;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)

@CucumberOptions(
			features = {"src/test/java/webAutomation/RunWebtest.feature"},
			glue = {"webAutomation","Hooks"},
	        plugin= {"pretty","summary","html:target/WebTest.html"},
	        monochrome = true,
	        dryRun=false, //If set to true automated browser does not start
	        snippets = SnippetType.CAMELCASE,
	        tags= "@All" //  "@Prod and not @Regression"
)

public class RunnerTest {
}