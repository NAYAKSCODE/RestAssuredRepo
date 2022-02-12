package com.RmgyantraTest;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUtility.BaseAPIClass;
import genericUtility.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoLibrary.PojoClass;

import static io.restassured.RestAssured.*;

public class UpdateProjectAndVerifyinDatabaseTest extends BaseAPIClass {
@Test
public void updateprojectandverifyindatabase() throws Throwable 
	{
		//Create test data
	
		PojoClass pojo = new PojoClass("Ashutosh","Buzz56", "Completed",12);
		Response response = given()
				.body(pojo)
				.contentType(ContentType.JSON)

	    //action-Update
				.when()
				.put(EndPoints.Updateproject);

		//get projectId From response body
		String expData = rLib.getJsonData(response, "status");
		Reporter.log(expData+" data found in response body", true);

		//varify in db
		String query= "select * from project;";
		String actData = dLib.executeQueryAndGetData(query,5, expData);
		Reporter.log(actData +" data created by in db", true);

		Assert.assertEquals(expData, actData);
		Reporter.log("Verification successful",true);

	}
}

