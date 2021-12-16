package CrudwithBDD;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import GenricUtil.EndtoEnd.Javautility;
import io.restassured.http.ContentType;

public class CreateprojectusingHashmapTest {

	@Test
	public void usinghashmap() {
		Javautility jv= new Javautility();
		HashMap hp=new HashMap();
		
		hp.put("createdBy", "NOOR");
		hp.put("projectName", "TYSS_PROJ_424"+jv.randomnumber());
		hp.put("status", "created");
		hp.put("teamsize", 4);	
		
		
		given()
		.contentType(ContentType.JSON)
		.body(hp)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat()
		.statusCode(201)
		.log().all();
		
		
	}
}
