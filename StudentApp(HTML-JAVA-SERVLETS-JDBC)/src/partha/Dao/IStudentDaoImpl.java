package partha.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.HikariConnection;
import partha.dto.Student;

public class IStudentDaoImpl implements IStudentDao 
{
	Connection connection =null;
	PreparedStatement ps = null;
	ResultSet resultSet = null;
	
	
	@Override
	public String addStudent(Student student) 
	{
			try 
			{
				connection = HikariConnection.getConnection();
				
				String sqlInsertQuery = "insert into student(name,age,address) values(?,?,?)";
				
				if(connection !=null)
				{
					 ps = connection.prepareStatement(sqlInsertQuery);
				}
				if(ps!=null)
				{
					ps.setString(1, student.getName());
					ps.setInt(2, student.getAge());
					ps.setString(3, student.getAddress());
					
					int rowAffected = ps.executeUpdate();
					
					if(rowAffected == 1)
					{
						return "success";
					}
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
 		return null;
	}

	@Override
	public Student searchStudent(Integer id) 
	{
		Student student = new Student();
		
		try 
		{
			connection = HikariConnection.getConnection();
			
			String sqlSearchQuery = "select*from student where id =?";
			
			if(connection !=null)
			{
				 ps = connection.prepareStatement(sqlSearchQuery);
			}
			if(ps!=null)
			{
				ps.setInt(1, id);
				resultSet =	ps.executeQuery();
			}
			if(resultSet!=null)
			{
				if(resultSet.next())
				{
					student.setId(resultSet.getInt("id"));
					student.setName(resultSet.getString("name"));
					student.setAge(resultSet.getInt("age"));
					student.setAddress(resultSet.getString("address"));
					
					return student;
				}
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
 		return null;
 		
 		
 		
 		
 		
	}

	@Override
	public String updateStudent(Student student) 
	{
		try 
		{
			connection = HikariConnection.getConnection();
			
			String sqlUpdatedQuery = "update student set name=?,age=?,address=? where id =?";
			
			if(connection !=null)
			{
				 ps = connection.prepareStatement(sqlUpdatedQuery);
			}
			if(ps!=null)
			{
				ps.setString(1, student.getName());
				ps.setInt(2, student.getAge());
				ps.setString(3, student.getAddress());
				ps.setInt(4, student.getId());
				
				int rowAffected = ps.executeUpdate();
				
				if(rowAffected == 1)
				{
					return "success";
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return "failed";
	}

	@Override
	public String deleteStudent(Integer id) 
	{
		try 
		{
			connection = HikariConnection.getConnection();
			
			String sqlDeleteQuery = "delete from student where id =?";
			
			if(connection !=null)
			{
				 ps = connection.prepareStatement(sqlDeleteQuery);
			}
			if(ps!=null)
			{
				 
				ps.setInt(1,id);
				
				int rowAffected = ps.executeUpdate();
				
				if(rowAffected == 1)
				{
					return "success";
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}

 		return null;
	}

}
