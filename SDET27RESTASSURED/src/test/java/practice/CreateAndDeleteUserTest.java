package practice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoLibrary.PojoClassEmployee;

import static io.restassured.RestAssured.*;

public class CreateAndDeleteUserTest {
	@Test
	public void createanddelete() {
		PojoClassEmployee pojo = new PojoClassEmployee("SDET","12/08/1995","ashutosh@gmail.com","ashutosh",4,"8794984932","paven","ROLE_ADMIN","paven");
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/employees");
	}

}
