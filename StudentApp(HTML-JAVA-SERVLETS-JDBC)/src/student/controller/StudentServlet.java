package student.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import partha.dto.Student;
import partha.service.IStudentServiceImpl;
import studentfactory.StudentServiceFactory;

 
@WebServlet("/Student/*")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 doProccess(request,response);
 	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 doProccess(request,response);
	}
	
	private void doProccess(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		IStudentServiceImpl studService = null;
		PrintWriter out = response.getWriter();
		
		
		if(request.getRequestURI().endsWith("addform"))
		{
			String name = request.getParameter("username");
			String age = request.getParameter("age");
			String address = request.getParameter("address");
			
			studService = StudentServiceFactory.getServiceObj();
			
			Student student = new Student();
			
			student.setName(name);
			student.setAge(Integer.parseInt(age));
			student.setAddress(address);
			
			String status = studService.addStudent(student);
			
			if(status.equalsIgnoreCase("success"))
			{
				out.println("<h1 style='color:red; text-align:center;'>Record Inserted Successfully.</h1>");
			}
			else
			{
				out.println("<h1 style='color;red text-align:center'>Record Insertion Failed.</h1>");
			}
			
			
		}
		

		if(request.getRequestURI().endsWith("deleteform"))
		{
			studService = StudentServiceFactory.getServiceObj();
			
			String id = request.getParameter("delid");
			
			String status = studService.deleteStudent(Integer.parseInt(id));
			
			if(status.equalsIgnoreCase("success"))
			{
				out.println("<h1 style='color:red; text-align:center;'>Record Deleted Successfully.</h1>");
			}
			else
			{
				out.println("<h1 style='color:red; text-align:center;'>Record Deletion Failed.</h1>");
			}
			
		}
	
				
		if(request.getRequestURI().endsWith("updateform"))
		{
			String id = request.getParameter("upid");
			
			studService = StudentServiceFactory.getServiceObj();
			
			Student student = studService.searchStudent(Integer.parseInt(id));
			
			if(student!=null)
			{
				out.println("<html>");
				out.println("<body>");
				out.println("<center>");
				
				out.println("<form method='post' action='./Student/updateRecord'>");
				out.println("<table>");
				out.println("<tr><th>ID</th><td>"+student.getId()+"</td></tr>");
				out.println("<input type='hidden' name='sid' value='"+student.getId()+"' />");
				out.println("<tr><th>NAME</th><td><input type='text' name ='sname' value=' "+student.getName()+" '/></td></tr>");
				out.println("<tr><th>AGE</th><td><input type='text' name ='sage' value='"+student.getAge()+"'/></td></tr>");
				out.println("<tr><th>ADDRESS</th><td><input type='text' name ='saddress' value=' "+student.getAddress()+" '/></td></tr>");
				out.println("<tr><td><input type='submit' value='update'></td></tr>"); 
				
				out.println("</table>");
				out.println("</form>");
				
				out.println("</center>");
				out.println("</body>");
				out.println("</html>");
				
			}
			else
			{
				out.println("<h1 style='color:red; text-align:center;'>Record Not Available.</h1>");

			}
			
			
			
		}
		if(request.getRequestURI().endsWith("updateRecord"))
		{
			String id = request.getParameter("sid");
			String name = request.getParameter("sname");
			String age = request.getParameter("sage");
			String address = request.getParameter("saddress");
			
			
			studService = StudentServiceFactory.getServiceObj();
			
			Student student = new Student();
			
			student.setId(Integer.parseInt(id));
			student.setName(name);
			student.setAge(Integer.parseInt(age));
			student.setAddress(address);
			
			
			
			String status = studService.updateStudent(student);
			
			if(status.equalsIgnoreCase("success"))
			{
				out.println("<h1 style='color:red; text-align:center;'>Record updation Successfully.</h1>");
			}
			else
			{
				out.println("<h1 style='color:red; text-align:center;'>Record updation Failed.</h1>");
			}
			
			
		}

		if(request.getRequestURI().endsWith("searchform"));
		{
			studService = StudentServiceFactory.getServiceObj();
			
			String id = request.getParameter("id");
			
			Student student = studService.searchStudent(Integer.parseInt(id));
			
			if(student!=null)
			{
			out.println("<html>");
			out.println("<body style='color:black; bgcolor:grey;'>");
			out.println("<center>");

			out.println("<table border='1'>");
			out.println("<tr><th>ID</th><td>"+student.getId()+"</td></tr>");
			out.println("<tr><th>NAME</th><td>"+student.getName()+"</td></tr>");
			out.println("<tr><th>AGE</th><td>"+student.getAge()+"</td></tr>");
			out.println("<tr><th>ADDRESS</th><td>"+student.getAddress()+"</td></tr>");
		
			out.println("</table>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
			}
			else
			{
				out.println("<h1 style='color;red text-align:center'>Record Not Found...</h1>");

			}
		}

		
			
	}

}
