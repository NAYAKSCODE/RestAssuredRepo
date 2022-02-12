package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BarrerToken {
	@Test
	public void barrertoken() {
		given().auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}

}
