package practiceCRUDWithOutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
@Test
public void Createproject() {
	//create test data
	JSONObject jobj= new JSONObject();
	jobj.put("createdBy","mohan");
	jobj.put("projectName","marjin");
	jobj.put("status","Created");
	jobj.put("teamSize",12);
	//provide Request specification
	RequestSpecification req = RestAssured.given();
	req.contentType(ContentType.JSON);
	req.body(jobj);
	//performed the action
	Response resp = req.post("http://localhost:8084/addProject");
	//print in console and verification
	System.out.println(resp.prettyPrint());
	System.out.println(resp.prettyPrint());
	System.out.println(resp.getContentType());
	System.out.println(resp.statusCode());
	
	
}
}
