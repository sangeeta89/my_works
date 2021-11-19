package webAutomation;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
			features = {"src/test/java/webAutomation/RunWebtest.feature"},
			glue = {"src/test/java/webAutomation"},
	        plugin= {"pretty","html:target/WebTest.html"},
	        dryRun=true,
	        monochrome = true
	       
)

public class Runner {
}
