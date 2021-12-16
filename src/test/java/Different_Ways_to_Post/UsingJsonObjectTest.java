package Different_Ways_to_Post;

import java.util.Random;

import org.json.simple.JSONObject;
import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UsingJsonObjectTest {
	@Test
	public void jsonobject() {
		Random r = new Random();
		int randomNumber = r.nextInt(2000);
		
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Noor");
		jobj.put("projectName", "TYSS"+randomNumber+"");
		jobj.put("status", "On Going");
		jobj.put("teamSize", 4);
		
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
