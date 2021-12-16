package CrudwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteprojectTest {
	
	
	@Test
	public void deletetest() {
		
		Response rs = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_206");
		System.out.println(rs.getStatusCode());
		ValidatableResponse vResponse = rs.then();
		vResponse.assertThat().statusCode(204);
		
		
	}

}
