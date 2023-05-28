package studentfactory;

import partha.Dao.IStudentDaoImpl;

public class StudentDaoFactory 
{

	 
	private static IStudentDaoImpl s = null;
	
	public static IStudentDaoImpl getDaoObj()
	{
		s = new IStudentDaoImpl();
		
		return s;
	}
}
