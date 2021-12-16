package GenricUtil.EndtoEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	public Connection con=null;
	public ResultSet result;
	
	
	
	/**
	 * This method is for connecting to data base
	 */
	
	public void connecttodatebase() {
		
		try {
			Driver dref=new Driver();
			DriverManager.registerDriver(dref);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 		
		
	}
	/**
	 * this method is for executing query
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet executeQuery(String query) throws Throwable {
		
		ResultSet result = con.createStatement().executeQuery(query);
		return result;
		
	}
	/**
	 * this method is for closing the connection
	 * @throws Throwable
	 */
public void closeconnection() throws Throwable {
	con.close();
	
	
}	

}
