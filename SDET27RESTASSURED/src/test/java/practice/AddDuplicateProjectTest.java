package practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddDuplicateProjectTest {
	@Test
	public void duplicate() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","deepak");
		jobj.put("projectName","marjin");
		jobj.put("status","Created");
		jobj.put("teamSize",10);
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
	}

}
