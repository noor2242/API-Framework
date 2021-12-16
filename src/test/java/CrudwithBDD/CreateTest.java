package CrudwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateTest {
	@Test
	public void createproject() {
		
Random r = new Random();
int randomvariable = r.nextInt(2000);
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "NOOR");
		jobj.put("projectName", "TYSS_PROJ_423"+randomvariable);
		jobj.put("status", "created");
		jobj.put("teamsize", 4);
		
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
		
		
	}

}
