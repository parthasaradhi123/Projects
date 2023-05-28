package Partha.ServiceFactory;

import Partha.service.IStudentService;
import Partha.service.StudentServiceImpl;


//Abstraction logic of implementation.......
public class StudentServiceFactory 
{
	//If you make a constructor private then we cannot create object of that class
	private StudentServiceFactory()
	{
		
	}
	private static IStudentService studentService = null;

	public static IStudentService getStudentServce()
	{
		//SingleTon Patern.
		if(studentService == null)
		{
			studentService = new StudentServiceImpl();
		}
		return studentService;
		
		
	}
}
