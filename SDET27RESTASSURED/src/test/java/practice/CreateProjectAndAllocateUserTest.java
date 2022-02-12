package practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojoLibrary.PojoClassEmployee;

import static io.restassured.RestAssured.*;

import java.util.Date;
import java.util.Random;

public class CreateProjectAndAllocateUserTest {
	@Test
	public void enetoend() {
		Random ran=new Random();
		int randomnum = ran.nextInt(100);
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","robin");
		jobj.put("projectName","robinhood"+randomnum);
		jobj.put("status","Created");
		jobj.put("teamSize",100);
	    Response response = given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject");
	    String project = response.jsonPath().get("projectName");
	    
	   PojoClassEmployee pojo = new PojoClassEmployee("SDET","25/05/1999","nithesh@gmail.com","nithesh"+randomnum,15,"9888777657",project,"ROLE_ADMIN","nithesh"+randomnum);
	    given()
	    .body(pojo)
	    .contentType(ContentType.JSON)
	    .when()
	    .post("http://localhost:8084/employees")
	    .then()
	    .assertThat().statusCode(201)
	    .contentType(ContentType.JSON)
	    .log().all();
		
		
	}

}
