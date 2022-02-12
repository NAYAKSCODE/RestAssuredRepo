package practiceCRUDWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
@Test
public void updateproject() {
	//create test data
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy","mohan");
	jobj.put("projectName","marjin");
	jobj.put("status","Completed");
	jobj.put("teamSize",10);
	//provide Request specification
	RequestSpecification req = RestAssured.given();
	req.contentType(ContentType.JSON);
	req.body(jobj);
	//performed the action
	Response resp = req.put("http://localhost:8084/projects/TY_PROJ_1602");
	//print and verification
	ValidatableResponse valid = resp.then();
	valid.assertThat().statusCode(200);
	valid.log().all();
	
	
}
}
