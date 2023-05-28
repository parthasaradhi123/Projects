package studentfactory;

import partha.service.IStudentServiceImpl;

public class StudentServiceFactory 
{
	private static IStudentServiceImpl s = null;
	
	public static IStudentServiceImpl getServiceObj()
	{
		
		s = new IStudentServiceImpl();
		return s;
		 
	}
}
