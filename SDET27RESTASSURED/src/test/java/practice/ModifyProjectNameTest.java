package practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ModifyProjectNameTest {
	@Test
	public void modify() {
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy","deepak");
		jobj.put("projectName","marjin003");
		jobj.put("status","Created");
		jobj.put("teamSize",10);
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_2002")
		.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all(); 
	}

}
