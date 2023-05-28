package Partha.service;

import Partha.Dto.Student;

public interface IStudentService
{

	//perfom crud opertions
	
	//insert
	public String addStudent(Integer sID, String sname,Integer age, String address);
	
	//select
	public Student searchStudent(Integer sId);
	
	//update 
	public String updateStudent(Student student);
	
	//delete
	public String deleteStudent(Integer sID);
}
