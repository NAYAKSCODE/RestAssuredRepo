package parameterAndAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class QueryParameterTest {
	@Test
	public void param() {
		given()
		.contentType(ContentType.JSON)
		.queryParam("delay","3")
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
		
	}

}
