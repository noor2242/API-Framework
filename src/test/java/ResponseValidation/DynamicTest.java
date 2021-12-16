package ResponseValidation;


import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import  io.restassured.response.Response;


public class DynamicTest {	
		
		@Test
		public void dynamictest() {
		
			String expdata="Noorulla176";
			 Response rsps = when().get("http://localhost:8084/projects");
			rsps.then().assertThat().statusCode(200);
			
		List<String> listdata = rsps.jsonPath().get("projectName");
		for (String actdata : listdata) {
			if (actdata.equals(expdata)) {
				System.out.println(actdata+"  is present");
				break;
			}
		}
			
		}

	}



