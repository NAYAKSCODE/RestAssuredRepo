package com.RmgyantraTest;


import static org.junit.Assert.assertArrayEquals;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericUtility.BaseAPIClass;
import genericUtility.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoLibrary.PojoClass;

import static io.restassured.RestAssured.*;

public class CreateProjectAndVerifyInDatabaseTest extends BaseAPIClass{
@Test
public void createprojectandverifyinDb() throws Throwable {
	//create test data
	PojoClass pojo = new PojoClass("Ashutosh","Buzz"+jLib.getRandomnum(),"Created",12);
	//Execute post request
	Response response = given()
	.body(pojo)
	.contentType(ContentType.JSON)
	.when()
	.post(EndPoints.Createproject);
	//capture the projectid from response
	String expdata = rLib.getJsonData(response,"projectId");
	System.out.println(expdata);
	//verify in database
	String query="select * from project;";
	String actdata = dLib.executeQueryAndGetData(query, 1, expdata);
	Reporter.log(actdata,true);
	//validate
	Assert.assertEquals(expdata,actdata);
	Reporter.log("data verification successful",true);
	
}
}
