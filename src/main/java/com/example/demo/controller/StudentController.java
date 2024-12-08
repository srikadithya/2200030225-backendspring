package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.model.StudentDao;

@RestController
@CrossOrigin
public class StudentController {

	@Autowired
	StudentDao sdao;
	
	@GetMapping("/")
	public String fun2()
	{
		return "welocome";
		
	}
	@PostMapping("/studentinsert")
	public String fun1(@RequestBody Student s)
	{
		return sdao.insertStudent(s);
		
	}
	
	@PostMapping("/loginstudent")
	  public boolean fun4(@RequestBody Map<String, String> requestBody) {
	      String email = requestBody.get("email");
	      String password = requestBody.get("password");
	      Student s = sdao.studentLogin(email);
	      if(s != null)
	      {
	    	  if(s.getPassword().equals(password))
	    	  {
	    		  return true;
	    	  }
	      }
	      return false;
	  }
}
