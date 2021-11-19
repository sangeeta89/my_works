package API;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
		features = {"src/test/java/API/restbdd.feature"},
        glue = "API",
        plugin= {"pretty","html:target/ApiTest.html"},
        monochrome = true

)
	public class TestRunner {
		 
	}
