package steps;

import com.consol.citrus.annotations.CitrusEndpoint;
import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.dsl.runner.TestRunner;
import com.consol.citrus.http.client.HttpClient;

//import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class APIFeatureIT {

	    @CitrusEndpoint
	    private HttpClient votingClient;
	 
	    @CitrusResource
	    protected TestRunner runner;

	    @Given("I have sample requestGetRequest {string}")
	    public void i_have_sample_requestGetRequest(String string) {
	    	System.out.println("*******************" + string);
	    	runner.http(action -> action.client(votingClient)
	                .send()
	                .get(string)
	                .contentType("application/json"));
	        // Write code here that turns the phrase above intoconcrete actions
//	        throw new PendingException();
	    }
		
	    @When("header resourceid is {string}")
	    public void header_resourceid_is(String string) {
	        // Write code here that turns the phrase above into concrete actions
//	        throw new PendingException();
	    }

	    @And("header Content-Type is {string}")
	    public void header_Content_Type_is(String string) {
	        // Write code here that turns the phrase above into concrete actions
//	        throw new PendingException();
	    }
		
		@And("header citrus_http_method is {string}")
		public void header_citrus_http_method_is(String string) {
		    // Write code here that turns the phrase above into concrete actions
//		    throw new PendingException();
		}

		@Then("header citrus_http_status_code is {int}")
		public void header_citrus_http_status_code_is(Integer int1) {
		    // Write code here that turns the phrase above into concrete actions
//		    throw new PendingException();
		}
		
//		@Given("I have sample requestGetRequest {endpoint}.")
//		public void i_have_sample_requestGetRequest(String endpoint) {
//		    // Write code here that turns the phrase above into concrete actions
//			System.out.println("Given");
//			runner.variable("http://reqres.in/api",endpoint);
//			runner.echo("GIVEN");
//		    throw new PendingException();
//		}
//		
//		@When("header resourceid is {string}")
//		public void header_resourceid_is(String resourceId) {
//		    // Write code here that turns the phrase above into concrete actions
//			runner.variable("unknown",resourceId);
//		    runner.echo("WHEN");
//		    throw new PendingException();
//		}
//		
//		@And("header Content-Type is {contentype}")
//		public void header_Content_Type_is(String contentype) {
//		    // Write code here that turns the phrase above into concrete actions
//		    runner.variable("application/json",contentype);
//		    throw new PendingException();
//		}
//		
//		@And("header citrus_http_method is {method}")
//		public void header_citrus_http_method_is(String method) {
//		    // Write code here that turns the phrase above into concrete actions
//			runner.variable("GET",method);
//	
//		    throw new PendingException();
//		}
//		
//		@Then("header citrus_http_status_code is {int}")
//		public void header_citrus_http_status_code_is(String hTTPStatusCode) {
//		    // Write code here that turns the phrase above into concrete actions
//			runner.echo(hTTPStatusCode);
//			throw new PendingException();
//		}
}