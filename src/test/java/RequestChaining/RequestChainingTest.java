package RequestChaining;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class RequestChainingTest {
@Test
	public void requestchaining() {
		
		
		
		Response rsps = given().get("http://localhost:8084/projects");
		String projectId = rsps.jsonPath().get("[2].projectId");
		System.out.println(projectId);
		given()
		.pathParam("ProId", projectId)
		.when()
		.delete("http://localhost:8084/projects/{ProId}")
		.then()
		.log()
		.all();
		
	}
	
}
