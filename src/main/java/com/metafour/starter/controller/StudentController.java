package com.metafour.starter.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metafour.starter.exception.MetafourStarterException;
import com.metafour.starter.model.*;
import com.metafour.starter.service.*;


/**
 * @author Noor Siddique
 * @since 26 Dec 2016
 *
 */
@Controller
@RequestMapping("/student")
public class StudentController {

	private final Map<String, String> COURSE = new HashMap<>();
	private final Map<String, String> COURSES = new HashMap<>();
	@Autowired StudentService studentService;
	@Autowired DestinationService destinationService;
	
	@PostConstruct
	private void init() {
		COURSE.put("1", "Bangla");
		COURSE.put("2", "English");
		COURSE.put("3", "Mathematics");
		COURSE.put("4", "Physics");
		COURSE.put("5", "Chemistry");
		COURSE.put("6", "Biology");
		COURSE.put("7", "Higher Mathematics");
		COURSE.put("8", "Histry");
		COURSE.put("9", "Geography");
		COURSE.put("10", "Accounting");
		COURSE.put("11", "Management");
		COURSE.put("12", "Finance and Banking");
		COURSES.put("13", "Computer");
		COURSES.put("23", "Agriculture");
		COURSES.put("33", "Social Science");
		COURSES.put("43", "Psycology");
		COURSES.put("53", "Phylosophy");
		COURSES.put("63", "Geology");
		COURSES.put("73", "Business Mathematics");
		COURSES.put("83", "Statistics");
		COURSES.put("93", "Marketing");
		COURSES.put("103", "Business Introduction");
		COURSES.put("113", "Islamic Studies");
		COURSES.put("123", "Taxation");
	}

	@RequestMapping
	public String newScreen(final ModelMap model) throws MetafourStarterException {
		return updateScreen(null, model);
	}
	
	@RequestMapping("/{id}")
	public String updateScreen(@PathVariable String id, final ModelMap model) throws MetafourStarterException {
		model.addAttribute("student", id == null ? new Student() : studentService.getById(id));
		model.addAttribute("courses", COURSE);
		model.addAttribute("subject", COURSES);
		model.addAttribute("board", Arrays.asList("Dhaka Board", "Chittagong Board", "Comilla Board", "Sylhet Board", "Rajshahi Board", "Rangpur Board", "Jessore Board"));
		model.addAttribute("group", Arrays.asList("Science", "Arts", "Business Studies"));
		return "student/student";
	}

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addNewResort(@Valid Student student, BindingResult binding, final ModelMap model) throws MetafourStarterException, BindException {
		Map<String, String> result = new HashMap<>();
		if (binding.hasErrors()) throw new BindException(binding);
		if (student.getId() == null || studentService.getById(student.getId()) == null)
			studentService.addStudent(student);
		else
			studentService.updateStudent(student);

		result.put("status", "success");
		result.put("redirect", "/" + student.getId());
		return result;
	}
}
