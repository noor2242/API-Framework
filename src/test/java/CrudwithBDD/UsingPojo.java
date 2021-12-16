package CrudwithBDD;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import Com.Rmgyantra.ProjectLibrary.PojoLibrary;
import io.restassured.http.ContentType;

public class UsingPojo {
	
	@Test
	public void pojo()
	{
		
		Random r = new Random();
		int randomvariable = r.nextInt(1000);
		PojoLibrary pl=new PojoLibrary("Noorullah", "TY56"+randomvariable, "Completed", 4);
		
		given().contentType(ContentType.JSON).body(pl).when().post("http://localhost:8084/addProject").then()
		.assertThat().statusCode(201).log().all();
		
		
	}

}
