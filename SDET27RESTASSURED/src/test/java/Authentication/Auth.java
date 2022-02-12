package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Auth {
	@Test
	public void auth() {
		Response response = given()
		.formParams("client_id","clube27")
		.formParams("client_secret","4b5cd25f334ca9cad57b629f03e3986a")
		.formParams("grant_type","client_credentials")
		.formParams("redirect_uri","https://example.com")
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		String token = response.jsonPath().get("access_token");
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID","2790")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		.then()
		.log().all();
		
		
	
	}

}
