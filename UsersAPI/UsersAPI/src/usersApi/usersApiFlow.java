package usersApi;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.log4testng.Logger;
import org.apache.logging.log4j.LogManager;

import comresourcepackage.Resource;

public class usersApiFlow extends Resource {
	
		public static org.apache.logging.log4j.Logger logger = LogManager.getLogger(usersApiFlow.class);
		
   public static void UsersAPI() throws IOException, JSONException {
	DataBody db = new DataBody();
	ResourcePath path = new ResourcePath();

	String req = given().spec(RequestData()).when().get(path.getApi()).then().log().all().statusCode(200).extract().asPrettyString();
	Response request = given().spec(RequestData()).body(db.DataUpdate()).log().all().when().post(path.getApi()).then().log().all().statusCode(201)
			.extract().response();
	JsonPath js = new JsonPath(request.asString());
	int id = js.getInt("id");
	System.out.println(id);
	JSONAssert.assertEquals(db.DataUpdate(), db.DataUpdates(), JSONCompareMode.LENIENT);
	logger.info("Response StatusCode",request.getStatusCode() );
   }
   public static void main (String[] args) throws IOException, JSONException {
	   UsersAPI();
   }
		
	}


