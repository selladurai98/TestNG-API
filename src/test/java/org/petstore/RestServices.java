 package org.petstore;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.data.PetDetails;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class RestServices {
	
	static int i;
	@DataProvider(name="pet")
	public Object[][] getPet(){
		return new Object[][] {{256,"siberian cat"},{257,"himalayan cat"},{258,"maine coon"}};
	}
	
	
  @Test(priority =1,dataProvider="pet")
	public void addPet( int id,String name) {
	RestAssured.baseURI = "https://petstore.swagger.io/v2";
	// add a new pet
	 String postresponse = given().log().all().header("Content-Type","application/json").body(PetDetails.petData(id,name,"status"))
		 .when().post("/pet") 
		.then().assertThat().statusCode(200).extract().response().asString();
	 System.out.println("response :"+postresponse);
	 
	 JsonPath j = new JsonPath(postresponse);
	  i = j.getInt("id");
	 System.out.println("pet ID:"+i);
	 
}
	
	// get pet by id
  @Test(priority =2)
     public void retrievePet() {
	given().log().all().header("Content-Type","application/json").pathParam("id",i)
	.when().get("/pet/{id}")
	.then().log().all().assertThat().statusCode(200);
  }
	// update the pet
  @Test(priority=3)
	public void updatePet() {
		given().log().all().header("Content-Type","application/json").body(PetDetails.petData(567,"cat","sold"))
		.when().put("/pet")
		.then().log().all().assertThat().statusCode(200);
	}
	
  @Test(priority=4)
  public void findByStatus() {
	  given().log().all().header("Content-Type","application/json").queryParam("status","sold")
	  .when().get("/pet/findByStatus")
	 .then().log().all().assertThat().statusCode(200);
  }
  
  
  
  
  
  
  
  
  
  
  
  
}
