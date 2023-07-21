package com.example.demo.hbonetoonedemo.dao;

import com.example.demo.hbonetoonedemo.entity.Instructor;

public interface InstructorDAO {
	void save(Instructor instructor);
	
	Instructor findInstructorById(int id);
	
	void deleteInstructorById(int id);
}
