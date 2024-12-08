package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Student;

public interface StudentInterface extends JpaRepository<Student, String>{
	public Student findStudentByEmail(String email);
	
}
