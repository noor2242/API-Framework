package Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Oauth2AuthenticationTest {
	@Test
	public void oauth() {
		
		Response rsps=given()
			.formParam("client_id","API_2242")
			.formParam("client_secret","91e1d590227d4f8d44ed6faec25843d1")
			.formParam("grant_type","client_credentials")
			.formParam("redirect_uri","https://example.com")
			.when()
			.post("http://coop.apps.symfonycasts.com/token");
			System.out.println(rsps.prettyPrint());
			String token = rsps.jsonPath().get("access_token");
			System.out.println(token);
			
		   given()
		   .auth().oauth2(token)
		   .pathParam("USER_ID", "2568")
		   .when()
		   .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		   .then()
		   .log()
		   .all();
		   
		   
		
	}

}
