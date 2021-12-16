package CrudwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	@Test
	public void createprojecttest() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "NOOR");
		jobj.put("projectName", "TYSS_PROJ_422");
		jobj.put("status", "created");
		jobj.put("teamsize", 4);
		
		
		RequestSpecification reqs = RestAssured.given();
		reqs.contentType(ContentType.JSON);
		reqs.body(jobj);
		
		Response response = reqs.post("http://localhost:8084/addProject");
		ValidatableResponse vresp = response.then();
		vresp.assertThat().statusCode(201);
		vresp.log().all();
		
		
	}

}
