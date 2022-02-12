package genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic methods to commands to database
 * @author ASHUTOSH NAYAK
 *
 */

public class DatabaseUtility {
	Connection conn=null;
	public void connecttoDB() throws Throwable {
		
		Driver driverref= new Driver();
		DriverManager.registerDriver(driverref);
	     conn = DriverManager.getConnection(IConstants.dbURL,IConstants.dbUserName,IConstants.dbPassword);
	}
	
	public void closeDB() throws Throwable {
		conn.close();
	}
 
	public String executeQueryAndGetData(String query,int columnindex,String expData) throws Throwable {
		boolean flag=false;
		ResultSet result = conn.createStatement().executeQuery(query);
		while(result.next())
		{
			String value = result.getString(columnindex);
			if(value.equalsIgnoreCase(expData))
			{
			flag=true;
			break;
			}
		}
	
	if(flag)
	{
		System.out.println(expData+"Data verified");
		return expData;
	}else
	{
		System.out.println("data not present");
		return " ";
	}
	
	}
}
