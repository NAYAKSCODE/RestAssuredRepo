package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;

public class Staticresponsevalidation {
	@Test
	public void validation() {
		String expproname = "SDETYANTRA";
	 Response resp = when()
				.get("http://localhost:8084/projects");
	 resp.jsonPath().get("http://localhost:8084/addproject");
	  
	 resp.then()
	 .assertThat()
	 .contentType(ContentType.JSON).and().statusCode(200)
	 .log().all();
	 Assert.assertEquals(expproname, expproname);
	}

}
