package Different_Ways_to_Post;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UsingHashMapTest {
	@Test
	public void hashmap() {
		
		
		Random r = new Random();
		int randomNumber = r.nextInt(2000);
		HashMap hp=new HashMap();
		hp.put("createdBy", "Noor");
		hp.put("projectName", "TYSS"+randomNumber+"");
		hp.put("status", "On Going");
		hp.put("teamSize", 4);
		
		given()
		.contentType(ContentType.JSON)
		.body(hp)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log()
		.all();
	}

}
