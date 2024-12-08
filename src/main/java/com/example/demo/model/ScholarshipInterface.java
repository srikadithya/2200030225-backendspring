package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Scholarship;



public interface ScholarshipInterface extends JpaRepository<Scholarship, Integer>{
	public Scholarship findById(int id);
}
