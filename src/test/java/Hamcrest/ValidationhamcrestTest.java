package Hamcrest;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ValidationhamcrestTest {
	
	
	@Test
	public void hamcrest() {
		
		when()
		.get("http://localhost:8084/")
		.then()
		.assertThat().time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS)
		.log()
		.all();
		
	}

}
