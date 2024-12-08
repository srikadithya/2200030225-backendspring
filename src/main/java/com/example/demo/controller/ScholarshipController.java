package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Scholarship;
import com.example.demo.model.ScholarshipDAO;

@RestController
@CrossOrigin
public class ScholarshipController {
	
	@Autowired
	ScholarshipDAO sdao;
	
	@PostMapping("/addapplication")
	public String fun1(@RequestBody Scholarship app) {
		return sdao.addApplication(app);
	}
	
	@GetMapping("/getapplication")
	public List<Scholarship> fun2(){
		return sdao.getApplication();
	}
	
	@PostMapping("/agreeapplication")
	public String fun2(@RequestBody Map<String, String> res) {
		int n = Integer.parseInt(res.get("id"));
		return sdao.agreeApplication(n);
	}
	
	@PostMapping("/rejectapplication")
	public String fun3(@RequestBody Map<String, String> res) {
		int n = Integer.parseInt(res.get("id"));
		return sdao.rejectApplication(n);
		//return res.get("id")+" found";
	}
	
	@GetMapping("/trackapplication")
	public Scholarship fun4(@RequestParam("id") int id) {
		//int id = Integer.parseInt(res.get("id"));
		return sdao.findApplication(id);
	}
}
