package com.metafour.starter.model;

import java.util.Date;

import lombok.Data;

@Data
public class Student {
	
	private String id;
	private String name;
	private String schoolboard;
	private String schoolpassingyear;
	private String groupschool;
	private String schoolresult;
	private String school;
	private String college;
	private String[] subject;
	private String collegeboard;
	private String collegepassingyear;
	private String groupcollege;
	private String collegeresult;
	private String[] collegesubject;
	private String fathersName;
	private String mothersName;
	private String sex;
	private String religion;
	private Date dateOfBirth;
	private String nationality;
	private String contactNo;
	private String permanentAddress;
	private String presentAddress;
	private String email;
	private String fatherOccupation;
	private String fatherContact;
	private String motherContact;
	private String motherOccupation;
	private String motherYearlyIncome;
	private String fatheryearlyIncome;
	private String homeAddress;
	private String officeAddress;
	
}
