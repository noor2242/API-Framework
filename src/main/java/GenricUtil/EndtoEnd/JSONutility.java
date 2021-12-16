package GenricUtil.EndtoEnd;


import io.restassured.response.Response;

public class JSONutility {

	public String jsonpathfinder(String jsonpath , Response rsps) {
		
	String text=rsps.jsonPath().getString(jsonpath);
	return text;
	}
	
}
