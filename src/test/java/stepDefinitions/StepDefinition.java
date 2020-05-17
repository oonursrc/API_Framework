package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.Utils;
import resources.APIResources;
import resources.TestDataBuild;

public class StepDefinition extends Utils {

	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	RequestSpecification req;
	TestDataBuild data = new TestDataBuild();
	static String place_Id;

	@Given("Add Place Payload with {string} {string}  {string}")
	public void add_Place_Payload_with(String name, String language, String address) throws FileNotFoundException {
		// Write code here that turns the phrase above into concrete actions

		res = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));

	}

	@When("User calls {string} with {string} HTTP request")
	public void user_calls_with_HTTP_request(String resource, String httpMethod) {
		// Write code here that turns the phrase above into concrete actions

		APIResources resurceapi = APIResources.valueOf(resource);
		System.out.println(resurceapi.getResource());

		resspec = new ResponseSpecBuilder().expectStatusCode(payloads.Payload.get_successStatusCode())
				.expectContentType(ContentType.JSON).build();

		if (httpMethod.equalsIgnoreCase("POST")) {
			response = res.when().post(resurceapi.getResource());
		} else if (httpMethod.equalsIgnoreCase("GET")) {
			response = res.when().get(resurceapi.getResource());
		}

		String responseString = response.asString();
		System.out.println(responseString);
	}

	@Then("The API call is success whith status code {int}")
	public void the_API_call_is_success_whith_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String exyectedValue) {
		// Write code here that turns the phrase above into concrete actions

		assertEquals(getJsonPath(response, keyValue), exyectedValue);
	}

	@Then("Verify place_Id created maps to {string} using {string}")
	public void verify_place_Id_created_maps_to_using(String expectedname, String resource) throws FileNotFoundException {
		// Write code here that turns the phrase above into concrete actions
		place_Id= getJsonPath(response, "place_id");

		res = given().spec(requestSpecification()).queryParam("place_id", place_Id);
		user_calls_with_HTTP_request(resource, "GET");
		
		String actualname= getJsonPath(response, "name");
		assertEquals(actualname,expectedname);
	}
	
	
	@Given("Delete Payload")
	public void delete_Payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions

		 res=given().spec(requestSpecification()).body(data.deletePlacePayload(place_Id));

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
