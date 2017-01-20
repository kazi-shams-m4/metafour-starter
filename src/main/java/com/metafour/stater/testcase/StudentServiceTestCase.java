package com.metafour.stater.testcase;

import java.util.List;

import org.junit.Test;

import com.metafour.starter.exception.MetafourStarterException;
import com.metafour.starter.model.Student;
import com.metafour.starter.service.StudentService;

public class StudentServiceTestCase {
	StudentService studentService = new StudentService();
	@Test
	public void testAddNewStudent() throws MetafourStarterException {
		Student student = new Student();
		student.setName("Mahbub");
		student.setContactNo("01912403800");
		studentService.addStudent(student);
		System.out.println("Create "+student.getId() + "," + student.getName() + ","+ student.getContactNo());
	}

	@Test
	public void testValidUpdateStudent() throws MetafourStarterException {
		Student student = new Student();
		Student student1 = new Student();
		student.setName("Mahbub");
		student.setContactNo("01912403800");
		studentService.addStudent(student);
		System.out.println(studentService);
		studentService.getById(student.getId());
		if(student.getId()!=null){
			student1.setId(student.getId());
			student1.setName("Kazi");
			student1.setContactNo("01912403800");
			studentService.updateStudent(student1);
			System.out.println(studentService);
			
			} 
		else {
			System.out.println("No Student found with ID or Name for Update!");
		}
	}
	
	@Test
	public void testDeleteStudent() throws MetafourStarterException {
		Student student = new Student();
		Student student1 = new Student();
		student.setName("Mahbub");
		student.setContactNo("01912403800");
		studentService.addStudent(student);
		System.out.println(studentService);
		studentService.getById(student.getId());
		if(student.getId()!=null){
			student1.setId(student.getId());
			student1.setName("Kazi");
			student1.setContactNo("01912403800");
			studentService.deleteStudent(student1);
			System.out.println("Delete "+studentService);
			
			} 
		else {
			System.out.println("No Student found with ID or Name for Update!");
		}
	}
	
	@Test
	public void testFindStudent() throws MetafourStarterException {
		StudentService studentService = new StudentService();
		Student student = new Student();
		student.setName("Mahbub");
		student.setContactNo("01912403800");
		studentService.addStudent(student);
		List<Student> list = studentService.find("Shams");
		if (list != null && list.size() > 0) {
			list.get(0);
			student = list.get(0);
			System.out.println(student.getId()+","+student.getName()+","+student.getContactNo());
			} 
		else {
			System.out.println("No Student found with ID or Name!");
		}
	}
}
