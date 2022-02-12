package parameterAndAuthentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class MultipleParameter {
	@Test
	public void param() {
	given()
	.pathParam("username","NAYAKSCODE")
	.queryParam("per_page","40")
	.queryParam("sort","pushed")
	.contentType(ContentType.JSON)
	.when()
	.get("https://api.github.com/users/{username}/repos")
	.then()
	.assertThat().statusCode(200)
	.contentType(ContentType.JSON)
	.log().all();
	}

}
