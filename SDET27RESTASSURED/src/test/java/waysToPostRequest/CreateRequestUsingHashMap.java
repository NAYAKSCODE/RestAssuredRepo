package waysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Random;

public class CreateRequestUsingHashMap {
	@Test
	public void create() {
		Random ran= new Random();
		int randomnum = ran.nextInt(500);
		HashMap map = new HashMap();
		map.put("createdBy","ashurosh");
		map.put("projectName","mapper123"+randomnum);
		map.put("status","Created");
		map.put("teamSize",12);
		given()
		.body(map)
		.contentType(ContentType.JSON)
	   .when()
	   .post("http://localhost:8084/addProject")
	   .then()
	   .assertThat().statusCode(201)
	   .contentType(ContentType.JSON)
	   .log().all();
	}

}
