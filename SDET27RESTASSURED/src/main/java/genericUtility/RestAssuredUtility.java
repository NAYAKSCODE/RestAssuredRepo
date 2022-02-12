package genericUtility;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

/**
 * This class contains generic method specific to restassured
 * @author ASHUTOSH NAYAK
 *
 */

public class RestAssuredUtility {
	/**
	 * This method will return jsondata from specific json path
	 * @param resp
	 * @param Jsonpath
	 * @return
	 */

	public String getJsonData(Response resp,String Jsonpath) {
		String jsonData = resp.jsonPath().get(Jsonpath);
		return jsonData;
	}

}
