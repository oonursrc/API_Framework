package resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {

	public static RequestSpecification req;
	TestDataBuild data = new TestDataBuild();

	public static JsonPath rawToJson(String response) {
		JsonPath js1 = new JsonPath(response); // takes text and converts to json
		return js1;
	}

	public RequestSpecification requestSpecification() throws FileNotFoundException {
		
		if(req==null) {
		PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
		RestAssured.baseURI = data.buildBaseURI();
		

		req = (RequestSpecification) new RequestSpecBuilder().setBaseUri(payloads.Payload.getbaseURL())
				.addQueryParam(payloads.Payload.get_paramKey(), payloads.Payload.get_paramValue())
				.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();

		return req;

		}
		
		return req; 
	}
	
	public String getJsonPath(Response response,String key) {
		
		String resp = response.asString();
		JsonPath js  = new JsonPath(resp);
		return js.get(key).toString();
	}

}
