package Partha.Utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtility 
{

	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getJdbcConnection()throws SQLException,IOException 
	{
		 
		HikariConfig config = 
	new HikariConfig("D:\\JavaApplication\\Projectstructure\\src\\Partha\\Utility\\Utility.properties");
		HikariDataSource  dataSource  = new HikariDataSource(config);
		
		return dataSource.getConnection();
		
	}
	

}
