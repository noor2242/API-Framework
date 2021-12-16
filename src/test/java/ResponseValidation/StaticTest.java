package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class StaticTest {

	@Test
	public void staticResponse()
	{
		
		String expData="Noorulla905";
		Response rsps = when().get("http://localhost:8084/projects");
		
		rsps.then().assertThat().statusCode(200);
		
		String actData = rsps.jsonPath().get("[6].projectName");
		System.out.println(actData);
		Assert.assertEquals(expData,actData);
	}

}
