package practiceCRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateResourse {
	@Test
	public void update() {
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy","ashutosh");
		jobj.put("projectName","marjin485");
		jobj.put("status","Completed");
		jobj.put("teamSize",10);
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1803")
		.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all(); 
	}

}
