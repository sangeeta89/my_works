package steps;
import cucumber.api.java.en.*;
import org.junit.Assert;

import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.dsl.runner.TestRunner;

public class VotingSteps {

	@CitrusResource
	private TestRunner runner;
	 
    @Given("^New default voting$")
    public void new_default_voting() {
    	System.out.println("inside given");
    }

    @When("^I create new voting$")
    public void i_create_new_voting() {
    	new_default_voting();
    }

    @Then("^voting title should be \"([^\"]*)\"$")
    public void voting_title_should_be(String title) {
        Assert.assertEquals(title, "Do you like Mondays?");
    }
}