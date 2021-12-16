package CrudwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Updatetest {
	
	@Test
   public void updatetest() {
	   
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "Akheel");
		jobj.put("projectName", "TYSS_PROJ_423");
		jobj.put("status", "created");
		jobj.put("teamsize", 4);
		
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_424")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	   
   }

}
