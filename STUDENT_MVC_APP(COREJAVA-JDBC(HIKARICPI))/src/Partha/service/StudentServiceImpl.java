package Partha.service;

import Partha.DaoFactory.StudentDaoFactory;
import Partha.Dto.Student;
import Partha.ServiceFactory.StudentServiceFactory;
import Partha.persistency.IStudentDao;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao studentDao;
 	@Override
	public String addStudent(Integer sID, String sname, Integer age, String address)
	{
 		studentDao = StudentDaoFactory.getStudentDao();
 		
  		return  studentDao.addStudent(sID, sname, age, address);
	}

	@Override
	public Student searchStudent(Integer sId) 
	{
 		studentDao = StudentDaoFactory.getStudentDao();
 		
 		return studentDao.searchStudent(sId);
	}

	@Override
	public String updateStudent(Student student)
	{
 		studentDao = StudentDaoFactory.getStudentDao();

 		return studentDao.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer sID) 
	{
 		studentDao = StudentDaoFactory.getStudentDao();

 		return studentDao.deleteStudent(sID);
	}

}
