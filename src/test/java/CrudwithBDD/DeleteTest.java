package CrudwithBDD;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DeleteTest {
	@Test
	public void delete() {
		
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_428")
		.then()
		.assertThat()
		.statusCode(204)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
