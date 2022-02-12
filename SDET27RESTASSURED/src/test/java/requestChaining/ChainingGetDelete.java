package requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ChainingGetDelete {
	@Test
	public void chaining() {
		Response response = when()
		.get("http://localhost:8084/projects");
	      String proid = response.jsonPath().get("[0].projectId");
	      given().pathParam("projectId",proid)
	      .when()
	      .delete("http://localhost:8084/projects/{projectId}")
	      .then()
	      .assertThat().statusCode(201)
	      .log().all();
		
		
	
	}

}
