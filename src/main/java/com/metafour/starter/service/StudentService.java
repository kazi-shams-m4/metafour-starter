package com.metafour.starter.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.metafour.starter.exception.MetafourStarterException;
import com.metafour.starter.model.*;

/**
 * @author Kazi
 * @since 26 Dec 2016
 *
 */
@Service
public class StudentService {
	List<Student> students = new ArrayList<>();

	public void addStudent(Student student) throws MetafourStarterException {
		student.setId(String.valueOf(new Random().nextLong()));
		students.add(student);
	}

	public void updateStudent(Student student) throws MetafourStarterException {
		List<Student> rsts = students.stream().filter(r -> r.getId().equals(student.getId())).collect(Collectors.toList());
		if (rsts.isEmpty())
			throw new MetafourStarterException("No Student found with ID '" + student.getId() + "' for update!");
		students.remove(rsts.get(0));
		students.add(student);
	}

	public void deleteStudent(Student student) throws MetafourStarterException {
		List<Student> rsts = students.stream().filter(r -> r.getId().equals(student.getId())).collect(Collectors.toList());
		if (rsts.isEmpty())
			throw new MetafourStarterException("No Student found with ID '" + student.getId() + "' for delete!");
		students.remove(rsts.get(0));
	}

	public List<Student> find(String hint) {
		return hint.equals("?") ? students : students.stream().filter(d -> d.getId().toLowerCase().contains(hint.toLowerCase()) || d.getName().toLowerCase().contains(hint.toLowerCase())).collect(Collectors.toList());
	}

	public Student getById(String id) throws MetafourStarterException {
		List<Student> rsts = students.stream().filter(r -> r.getId().equals(id)).collect(Collectors.toList());
		if (rsts.size() != 1)
			return null;
		return rsts.get(0);
	}

	@Override
	public String toString() {
		return "StudentService [students=" + students + "]";
	}
	
}
