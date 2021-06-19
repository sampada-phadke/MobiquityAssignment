package stepDefinitions;

import java.util.Map;

import org.testng.Assert;

import Utilities.RestAssuredUtility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class UserStepDef {
	
	private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
	private static String uid;
	Response res;
	@Given("^I have access to UsersAPI$")
	public void i_have_access_to_UsersAPI() throws Throwable {
		
	
	}

	@When("^I send Get request for the user \"([^\"]*)\"$")
	public void i_send_Get_request_for_the_user(String username) throws Throwable {
		
		RestAssured.baseURI = BASE_URL+"/users";
	    res =  RestAssuredUtility.getWithQueryparameters(RestAssured.baseURI, "username",username);
		uid = res.jsonPath().getString("id");
		System.out.println("uid is"+uid);
			
	}

	@Then("^I should validate StatusCode$")
	public void i_should_validate_StatusCode() throws Throwable {
		
		RestAssuredUtility.verifyStatusCode(res, 200);
		
	}


}
