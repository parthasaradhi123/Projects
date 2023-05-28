package Partha.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import Partha.Dto.Student;
import Partha.ServiceFactory.StudentServiceFactory;
import Partha.service.IStudentService;

public class TestApp {

	public static void main(String[] args) throws Exception 
	{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true)
		{
			System.out.println("1. CREATE");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			
			System.out.println("Enter your choice :: press[1/2/3/4/5]:: ");
			String option = br.readLine();
			
			switch(option)
			{
				case"1":
					insertOpertaion();
					break;
				case"2":
					selectOperation();
					break;
				case"3":
					updateOperation();
					break;
				case"4":
					deleteOperation();
					break;
				case"5":
					System.out.println("*************Thanks a lot for using our application***************");
					System.exit(0);
				default:
					System.out.println("Invalid option please please try again with valid option.......");
						break;
						
			}

		}
		
		 
		 
		
	}
	
	private static void updateOperation() throws Exception 
	{
		
		Scanner sc = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Student ID to be updated ");
		String id = br.readLine();
		
		
		IStudentService studentService = StudentServiceFactory.getStudentServce();
		Student student = studentService.searchStudent(Integer.parseInt(id));
		
		if(student!=null)
		{
			Student newStudent = new Student();
			
			System.out.println("Studet Id is :: "+student.getId());
			newStudent.setId(student.getId());
			
			System.out.println("Student oldName is :: "+student.getName()+ "   Enter new Name :: ");
			String newName = br.readLine();
			if(newName==" "||newName.equals(""))
			{
				newStudent.setName(student.getName());
			}
			else
			{
				newStudent.setName(newName);
			}
			
			
			System.out.println("Student oldAge is :: "+student.getAge()+"  Enter new Age :: ");
			String newAge = br.readLine();
			if(newAge.equals("")||newAge==" ")
			{
				newStudent.setAge((student.getAge()));
			}
			else
			{
				newStudent.setAge(Integer.parseInt(newAge));;
			}
			
			System.out.println("Student oldAddress is :: "+student.getAddress()+"  Enter new Address :: ");
			String newAddress = br.readLine();
			
			if(newAddress.equals("")||newAddress==" ")
			{
				newStudent.setAddress(student.getAddress());
			}
			else
			{
				newStudent.setAddress(newAddress);
			}
			
			
			String status =studentService.updateStudent(newStudent);
			
			if(status.equalsIgnoreCase("success"))
			{
				System.out.println("Record updates successfully..");
			}
			else
			{
				System.out.println("Record updation failed..");

			}

			
			
			
		}
		else
		{
			System.out.println("Stuent record not available for the given id :: "+id);
		}
 
	}
	
	private static void deleteOperation()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println(":: Enter the Student ID :: ");
		int id = sc.nextInt();
		
		IStudentService studentService = StudentServiceFactory.getStudentServce();
		
		String msg = studentService.deleteStudent(id);
		
		if(msg.equals("success"))
		{
			System.out.println("Record deletion Successfull ");
		}
		else
		{
			System.out.println("Record deletion Failed ");
		}
		
	 
		
		
	}
	
	
	private static void selectOperation()
	{
		Scanner sc = new Scanner(System.in);

		System.out.println(":: Enter the Student ID :: ");
		int id = sc.nextInt();

		IStudentService studentService = StudentServiceFactory.getStudentServce();
		
		Student std = studentService.searchStudent(id);
		
		if(std!=null)
		{
			System.out.println(std);
			
			System.out.println(std.getId()+"\t"+std.getName()+"\t"+std.getAge()+"\t"+std.getAddress());
		
		}
		else
		{
			System.out.println("Record not found for this Id ::"+ id);
		}
		
		
		
		 
	}
	
	private static void insertOpertaion()
	{
		IStudentService studentService = StudentServiceFactory.getStudentServce();
		
		Integer id = null;
		String name = null;
		Integer age = null;
		String address = null;
		
		Scanner sc = new Scanner(System.in);
	
		System.out.println(":: Enter the Student id :: ");
		id = sc.nextInt();
		
		System.out.println(":: Enter  the student name :: ");
		name = sc.next();
		
		System.out.println(":: Enter the Student age ::");
		age  = sc.nextInt();
		
		System.out.println(":: Enter the Student Address ::");
		address = sc.next();
		
		
		String msg = studentService.addStudent(id, name, age, address);
		
		if(msg.equals("success"))
		{
			System.out.println("Record Insertion Successfull ");
		}
		else
		{
			System.out.println("Record Insertion Failed ");
		}
		
		
		 
	
	}
}
