<%@ page language="java" import ='java.sql.*'%>

<%!

	Connection connection=null;
	PreparedStatement statement1 = null;
	PreparedStatement statement2 = null;

	public void jspInit()
	{
		ServletConfig config = getServletConfig();
		String url = config.getInitParameter("url");
		String username= config.getInitParameter("user");
		String password= config.getInitParameter("password");
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			
			statement1 = connection.prepareStatement("insert into Employee1(name,address,salary)values(?,?,?)");
			statement2 = connection.prepareStatement("select * from Employee1");
			
			
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	}
%>
	
	
<% 
	String action = request.getParameter("s1");
	if(action.equalsIgnoreCase("register"))
	{
		//Take the data and perform insert operation.
		
		String ename = request.getParameter("eName");
		String eAddress = request.getParameter("eAddress");
		String salary = request.getParameter("eSalary");
		
		statement1.setString(1,ename);
		statement1.setString(2,eAddress);
		statement1.setInt(3,Integer.parseInt(salary));

		int rowCount = statement1.executeUpdate();
		if(rowCount>0)
		{
			out.println("<h1 style='color:green; text-align:center;'>Employee Registered Successfully.</h1>");
		}
		else
		{
			out.println("<h1 style='color:green; text-align:center;'>Employee Registration Failed.</h1>");
		}
		
	}
	else
	{
		ResultSet resultSet = statement2.executeQuery();
		out.println("<html>");
		out.println("<body bgcolor='lightgrey'>");
		out.println("<center>");
		out.println("<table border='1'>");
		
		out.println("<tr><th>ID</th><th>NAME</th><th>ADDRESS</th><th>SALARY</th></tr>");
	
		while(resultSet.next())
		{
			out.println("<tr>");
			out.println("<td>"+resultSet.getInt(1)+"</td>");
			out.println("<td>"+resultSet.getString(2)+"</td>");
			out.println("<td>"+resultSet.getString(3)+"</td>");
			out.println("<td>"+resultSet.getInt(4)+"</td>");
			out.println("</tr>");
			
		}
		

	 
		out.println("</table>");
		out.println("<br/>");
		out.println("<a href='./index.html'>HOMEPAGE</a>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		

	}
%>


<%!
public void jspDestroy()
	{
		try
		{
			if(statement1 != null)
			{
				statement1.close();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			if(statement2 != null)
			{
				statement2.close();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			if(connection!= null)
			{
				connection.close();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

%>
 