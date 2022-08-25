package org.petstore;

import static io.restassured.RestAssured.given;

import org.data.PetDetails;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Normal {
	
	public static void main(String[] args) {
	

	RestAssured.baseURI = "https://petstore.swagger.io/v2";
	// add a new pet
	 String postresponse = given().log().all().header("Content-Type","application/json").body(PetDetails.petData(248,"tiger","status"))
		 .when().post("/pet") 
		.then().assertThat().statusCode(200).extract().response().asString();
	 System.out.println("response :"+postresponse);
	 
	 JsonPath j = new JsonPath(postresponse);
	  int i = j.get("id");
	 String name = j.getString("name");
	 String status = j.getString("status");
	 System.out.println("pet id:"+ i);
	 System.out.println(name);
	 System.out.println(status);
}
	

}
