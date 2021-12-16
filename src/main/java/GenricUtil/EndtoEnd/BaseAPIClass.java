package GenricUtil.EndtoEnd;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPIClass {

	public DataBaseUtility Dutil=new DataBaseUtility();
	
	@BeforeSuite
	public void connecttoDB()
	{
		Dutil.connecttodatebase();
	}
	
	@AfterSuite
	public void closeDB() throws Throwable {
		Dutil.closeconnection();
	}
}
