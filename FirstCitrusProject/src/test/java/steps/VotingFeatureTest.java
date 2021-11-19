package steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
				features= {"src/test/resources/features"},
				plugin = {"com.consol.citrus.cucumber.CitrusReporter"},
				glue = {"myproject", 
						"com.consol.citrus.cucumber.step.runner.core"})
public class VotingFeatureTest {
}