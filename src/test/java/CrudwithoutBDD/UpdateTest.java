package CrudwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class UpdateTest {
	@Test
	public void update() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Akheel");
		jobj.put("projectName", "TYSS_PROJ_422");
		jobj.put("status", "created");
		jobj.put("teamsize", 4);
		

		RequestSpecification reqs = RestAssured.given();
		reqs.contentType(ContentType.JSON);
		reqs.body(jobj);
		
		Response response = reqs.put("http://localhost:8084/projects/TY_PROJ_414");
		ValidatableResponse vresp = response.then();
		vresp.assertThat().statusCode(200);
		vresp.log().all();
		
		
		
		
	}

}
