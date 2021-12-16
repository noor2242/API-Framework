package Authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class BarerTokenTest
{
	
	@Test
	public void barerToken()
	{
		given()
		.auth().oauth2("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")
		.when()
		.get("https://api.github.com/user/repos")
		.then()
		.log()
		.all();
	}
}
