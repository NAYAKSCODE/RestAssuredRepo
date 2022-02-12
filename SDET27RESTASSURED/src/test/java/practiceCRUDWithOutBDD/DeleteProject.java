package practiceCRUDWithOutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
	@Test
	public void deleteproject() {
		//performed action
		int expstatus=204;
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1602");
		//print and verification
		int actstatus = resp.getStatusCode();
		Assert.assertEquals(expstatus, actstatus);
		System.out.println(resp.prettyPrint());
		
		
	}

}
