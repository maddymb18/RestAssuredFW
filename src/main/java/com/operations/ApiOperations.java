package com.operations;

import java.util.HashMap;

import com.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiOperations extends TestBase {

	public RequestSpecification httpRequest;

	public RequestSpecification request() {
		// Request Object
		httpRequest = RestAssured.given();
		//log("HTTP request created");
		return httpRequest;
	}

	public Response getOperation() {
		Response response = request().get();
		return response;
	}

	public int getStatusCode() {

		return getOperation().getStatusCode();
		
	}

	public String jsonResponse() {

		return getOperation().prettyPrint();

	}

	public String getStatusLine() {

		return getOperation().getStatusLine();

	}
	
	public Headers getHeaders() {

		return getOperation().getHeaders();

	}

	public void setHeaders() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("one", "one");
		
	RequestSpecification abc = request().headers(headers);
		
	}
	
	
}
