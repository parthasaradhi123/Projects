package Partha.persistency;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Partha.Dto.Student;
import Partha.Utility.JdbcUtility;

public class StudentDaoImpl implements IStudentDao {

	//Here you need to write Database connection logic.
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet resultSet = null;
	
	
	@Override
	public String addStudent(Integer sID, String sname, Integer age, String address) 
	{
		
		
		try
		{
			connection = JdbcUtility.getJdbcConnection();
			
			String sqlInsertQuery = "insert into student(id,name,age,address) values(?,?,?,?)";
			
			if(connection!=null)
			{
				ps = connection.prepareStatement(sqlInsertQuery);
			}
			if(ps!=null)
			{
				ps.setInt(1, sID);
				ps.setString(2, sname);
				ps.setInt(3, age);
				ps.setString(4, address);
			}
			int rowAffected = ps.executeUpdate();
			
			if(rowAffected == 1)
			{
				return "success";
			}
			
			
		} 
		catch (SQLException | IOException e) 
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		 
		return "failure";
		
		
 		
	}

	@Override
	public Student searchStudent(Integer sId)
	{
		 
		String sqlSelectQuery = "select id,name,age,address from student where id = ?";
		Student student = null;
				
		try
		{
			connection = JdbcUtility.getJdbcConnection();
				
			if(connection!=null)
			{
				ps = connection.prepareStatement(sqlSelectQuery);
			}
			if(ps!=null)
			{
				ps.setInt(1, sId);
			}
			if(ps!=null)
			{
				resultSet = ps.executeQuery();
			}
			
			if(resultSet!=null)
			{
				if(resultSet.next())
				{
					student = new Student();
					
					student.setId(resultSet.getInt(1));
					student.setName(resultSet.getString(2));
					student.setAge(resultSet.getInt(3));
				    student.setAddress(resultSet.getString(4));
				    
				    return student;
					
				}
			}
			 
			
		} 
		catch (SQLException | IOException e) 
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
 
		
 		return student;
	}

	 

	@Override
	public String deleteStudent(Integer sID) 
	{
		String sqlDeleteQuery = "delete from student where id = ?";
		int x = 0;
		
		try 
		{
			connection = JdbcUtility.getJdbcConnection();
			if(connection!=null)
			{
				ps = connection.prepareStatement(sqlDeleteQuery);
			}
			if(ps!=null)
			{
				ps.setInt(1, sID);
				x = ps.executeUpdate();
				
			}
			if(x==1)
			{
				return "success";
			}
		} 
		
		catch (SQLException | IOException e) 
		{
 			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
 		return "failed";
	}

	@Override
	public String updateStudent(Student student) 
	{
		String sqlUpdatedQuery = "update student set name=?,age=?,address=? where id=?";
		try
		{
			connection = JdbcUtility.getJdbcConnection();
			if(connection!=null)
			{
				ps = connection.prepareStatement(sqlUpdatedQuery);
				
			}
			if(ps!=null)
			{
				ps.setInt(4, student.getId());
				ps.setString(1, student.getName());
				ps.setInt(2, student.getAge());
				ps.setString(3, student.getAddress());
				
				int a = ps.executeUpdate();
	
			if(a == 1)
			{
				return "success";
			}
				
			}
		}
		catch(SQLException |IOException e)
		{
			e.printStackTrace();
		}
		
 		return "failure";
	}

}
