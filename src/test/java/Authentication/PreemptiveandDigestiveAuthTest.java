package Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PreemptiveandDigestiveAuthTest {
	
	@Test
	public void preemptive() {
		
		given()
		.auth()
		.preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("http://localhost:8084/login")
		.then()
		.assertThat()
		.statusCode(202);
		
	}
	@Test
	public void digestive() {
		given()
		.auth()
		.digest("rmgyantra", "rmgy@9999")
		.when()
		.get("http://localhost:8084/login")
		.then()
		.assertThat()
		.statusCode(202)
		.log()
		.all();
		
	}

}
