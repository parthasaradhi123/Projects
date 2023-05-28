package partha.service;

import partha.Dao.IStudentDaoImpl;
import partha.dto.Student;
import studentfactory.StudentDaoFactory;

public class IStudentServiceImpl implements IStudentService {

	IStudentDaoImpl s = null;
	@Override
	public String addStudent(Student student)
	{
		s = StudentDaoFactory.getDaoObj();
 		return s.addStudent(student);
	}

	@Override
	public Student searchStudent(Integer id) 
	{
		s = StudentDaoFactory.getDaoObj();

 		return s.searchStudent(id);
	}

	@Override
	public String updateStudent(Student student) 
	{
		s = StudentDaoFactory.getDaoObj();

 		return s.updateStudent(student);
	}

	@Override
	public String deleteStudent(Integer id) 
	{
		s = StudentDaoFactory.getDaoObj();

 		return s.deleteStudent(id);
	}

}
