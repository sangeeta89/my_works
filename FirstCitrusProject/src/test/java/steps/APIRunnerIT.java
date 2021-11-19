package steps;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= { "pretty","com.consol.citrus.cucumber.CitrusReporter"},
				glue= {"steps" ,"com.consol.citrus.cucumber.step.runner.core"},
				features= { "src/test/resources/com/citrus/myproject/TestApi.feature"})
				
public class APIRunnerIT {
}
//glue= {"src.test.java.steps" ,"com.consol.citrus.cucumber.step.runner.core"},
//"pretty","html:target/cucumber-reports", "json:target/cucumber.json",