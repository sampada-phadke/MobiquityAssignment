package Utilities;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.Map;
public class RestAssuredUtility {
	
	public static void verifyStatusCode(Response res, int expectedStatusCode) {
		int status = res.getStatusCode();
		res.then().assertThat().statusCode(expectedStatusCode);
	}
	public static Response getWithQueryparameters(String URI, String key,String value) {
		Response res = given().log().all().param(key, value).when().get(URI);
		return res;
		
		//System.out.println(res);
	}

	public static Response getWithQueryparameters(String URI, String authToken, Map queryParameters) {
		Response res = setAuthToken(authToken).params(queryParameters).when().get(URI);
		return res;
	}

	public static Response putWithQueryparameters(String authToken, Map queryParameters, String URI) {
		Response res = setAuthToken(authToken).params(queryParameters).when().put(URI);
		return res;
	}

	public static Response getWithPathParameters(String authToken, String URI) {
		Response res = setAuthToken(authToken).when().get(URI);
		return res;
	}
	
	public static RequestSpecification setAuthToken(String authToken) {
		return given().log().all().headers("iPlanetDirectoryPro", authToken);
	}
	

}
