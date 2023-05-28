package partha.service;

import partha.dto.Student;

interface IStudentService
{
		//Implement this method to add student details
		public String addStudent(Student student);
		
		//Implement this method to read Student data.
		public Student searchStudent(Integer id);
		
		
		//Implement this method to update student records.
		public String updateStudent(Student student);
		
		
		//Implement This method to delete student records.
		public String deleteStudent(Integer id);
}
