package EndtoEndscenario;

import org.testng.annotations.Test;

import Com.Rmgyantra.ProjectLibrary.PojoLibrary;
import GenricUtil.EndtoEnd.BaseAPIClass;
import GenricUtil.EndtoEnd.DataBaseUtility;
import GenricUtil.EndtoEnd.EndtoEndPoints;
import GenricUtil.EndtoEnd.Javautility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.ResultSet;

public class EndtoEndscenarioTest extends BaseAPIClass implements EndtoEndPoints  {

	@Test
	public void endToEndScenario() throws Throwable

	{
      baseURI="http://localhost";
      port=8084;
		Javautility jUtil = new Javautility();

		PojoLibrary pl = new PojoLibrary("SSS", "TechM" + jUtil.randomnumber(), "Created", 7);

		Response rsps = given().contentType(ContentType.JSON).body(pl).when().post(EndtoEndPoints.createproj);

		String projectid = rsps.jsonPath().get("projectId");
		System.out.println(projectid);

		Response rsps1 = given().pathParam("ProId", projectid).when().get("http://localhost:8084/projects/{ProId}");

		String proName = rsps1.jsonPath().get("projectName");
		System.out.println(proName);

		Dutil.connecttodatebase();
		
		ResultSet result = Dutil.executeQuery("select * from project");
		while (result.next()) 
		{
			if ((result.getString(4)).equals(proName))
			{
				System.out.println(proName+" is matching");
			}
		}
		

	}

}
