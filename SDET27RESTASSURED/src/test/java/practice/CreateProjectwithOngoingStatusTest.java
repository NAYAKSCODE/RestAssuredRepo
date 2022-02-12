package practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectwithOngoingStatusTest {
	@Test
	public void create() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","reepak");
		jobj.put("projectName","marjin12");
		jobj.put("status","on Going");
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
