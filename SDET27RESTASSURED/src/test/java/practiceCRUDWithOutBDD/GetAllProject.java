package practiceCRUDWithOutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProject {
	@Test
	public void getallproject()
	{
		//performed the action
		int expstats=200;
		Response resp = RestAssured.get("http://localhost:8084/projects");
		//print and verification
		System.out.println(resp.prettyPrint());
		int actstatus = resp.getStatusCode();
	    Assert.assertEquals(expstats, actstatus);
	}
}
