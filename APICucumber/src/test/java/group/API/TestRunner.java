package group.API;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(
		features = "group.API/restbdd.feature",
        glue = {"group.API"},
        monochrome = true

)
	public class TestRunner {
		 
	}
