package CrudwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetallprojectsTest {
	
	@Test
	public void getallprojecttest() {
		
		Response rs = RestAssured.get("http://localhost:8084/projects");
		//System.out.println(rs.prettyPrint());
		//System.out.println(rs.getContentType());
		//System.out.println(rs.getStatusCode());
		ValidatableResponse vResponse = rs.then();
		vResponse.assertThat().statusCode(200);
		//vResponse.assertThat().contentType("application/jason");
		vResponse.log().all();
	}
	

}
