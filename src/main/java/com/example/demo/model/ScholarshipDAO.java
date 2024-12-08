package com.example.demo.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Scholarship;

@Component
public class ScholarshipDAO {
	@Autowired
	ScholarshipInterface sdao;
	
	public String addApplication(Scholarship app) {
		try {
			sdao.save(app);
			return "Application Saved";
		}
		catch(Exception e) {
			return "Application not Saved";
		}
	}
	
	public List<Scholarship> getApplication(){
		return sdao.findAll();
	}
	
	public String agreeApplication(int id) {
		try {
			Scholarship res = sdao.findById(id);
			sdao.delete(sdao.findById(id));
			res.setStatus(true);
			System.out.println(res);
			sdao.save(res);
			return "Application Accepted";
		}
		catch(Exception e) {
			//return "Internal error";
			return id+e.getMessage();
		}
		
	}
	
	public String rejectApplication(int id) {
		try {
			Scholarship res = sdao.findById(id);
			sdao.delete(sdao.findById(id));
			res.setStatus(false);
			System.out.println("Updated status: "+res.getStatus());
			sdao.save(res);
			return "Application not Accepted";
		}
		catch(Exception e) {
			return "Internal error";
		//	return e.getMessage();
		}
		
	}
	
	public Scholarship findApplication(int id) {
		try {
			return sdao.findById(id);
		}
		catch(Exception e) {
			return null;
		}
	}
}
