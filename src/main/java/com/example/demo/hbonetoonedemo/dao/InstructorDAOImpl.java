package com.example.demo.hbonetoonedemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.hbonetoonedemo.entity.Instructor;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class InstructorDAOImpl implements InstructorDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void save(Instructor instructor) {
		entityManager.persist(instructor);
	}

	@Override
	public Instructor findInstructorById(int id) {
		Instructor instructor = entityManager.find(Instructor.class, id);
		return instructor;
	}

	@Override
	@Transactional
	public void deleteInstructorById(int id) {
		Instructor instructor = entityManager.find(Instructor.class, id);
		entityManager.remove(instructor);
	}
	
	
}
