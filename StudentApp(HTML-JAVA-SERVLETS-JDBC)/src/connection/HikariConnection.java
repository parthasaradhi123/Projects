package connection;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariConnection 
{
	
	static
	{
		try 
		{
			Class c = Class.forName("com.mysql.cj.jdbc.Driver"); 
			
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() throws SQLException
	{
		HikariConfig config = new HikariConfig("D:\\JavaApplication\\StudentApp\\src\\properties\\Utility.properties");
		HikariDataSource dataSource = new HikariDataSource(config);
		
		return dataSource.getConnection();
	}
}
