package practiceCRUDWithOutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {
	@Test
	public void getsingleproject() {
		//performed action 
		Response resp = RestAssured.get("http://localhost:8084/projects/TY_PROJ_1602");
		//print 
		System.out.println(resp.prettyPrint());
	}

}
