package dummyAPi;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.net.URI;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.RESOURCEPATH;
import resources.Utills;

public class DummyRestAPI extends Utills{
	
	@Test
	public static void EndToEnd() throws IOException, JSONException {
		//get api
		//String pdatejson = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";
		RESOURCEPATH PATH = new RESOURCEPATH();
		 
		System.out.println("get all employees");

		Response getapi = given().spec(RequestData()).when().get(PATH.getallid()).then().log().all().extract().response();
		//getID
		System.out.println("get all employees by id");
		Response getapibyid = given().spec(RequestData()).when().get("api/v1/employee/5").then().log().all().extract().response();

		 System.out.println("update employees");
		 Response getupdateapi = given().spec(RequestData()).body(updatejsonBody()).when().put("api/v1/update/24").then().
		 		log() .all().extract().response();

		 
		 //Delete Method
		 System.out.println("delete employees");
		 Response getdeleteapi = given().spec(RequestData()).when().delete("api/v1/delete/20").then().log().all().extract().response();

		//JSONAssert.assertEquals(updatejsonBody(),updatejsonBodydup(), JSONCompareMode.LENIENT);
		
		
		
		
		
		
		
		
		
		
	}

}
