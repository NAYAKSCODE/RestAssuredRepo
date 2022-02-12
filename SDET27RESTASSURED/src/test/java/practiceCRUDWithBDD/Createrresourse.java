package practiceCRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class Createrresourse {
	@Test
	public void createresourse()
	{
		Random ran=new Random();
		int randomnum = ran.nextInt(500);
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy","mohan");
		jobj.put("projectName","marjin"+randomnum);
		jobj.put("status","Created");
		jobj.put("teamSize",12);
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
		
	}

}
