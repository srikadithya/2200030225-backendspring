package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Student;

@Component
public class StudentDao {

	@Autowired
	StudentInterface srepo;
	public String insertStudent(Student s)
	{
		try {
			srepo.save(s);
			return "Student added";
		}
		catch(Exception e)
		{
			return "Student not added";
		}
	}
	
	public Student studentLogin(String email)
	{
		Student s=srepo.findStudentByEmail(email);
		return s;
	}
	
}
