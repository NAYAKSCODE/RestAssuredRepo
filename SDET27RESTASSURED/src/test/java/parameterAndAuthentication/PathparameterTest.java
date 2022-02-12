package parameterAndAuthentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathparameterTest {
	@Test
	public void param() {
     given()
     .pathParam("projectId","TY_PROJ_1803")
     .contentType(ContentType.JSON)
     .when()
     .delete("http://localhost:8084/projects/{projectId}")
     .then()
     .assertThat().statusCode(204)
     .contentType(ContentType.JSON)
     .log().all();
	}

}
