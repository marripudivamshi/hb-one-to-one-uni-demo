package com.example.demo.hbonetoonedemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.hbonetoonedemo.dao.InstructorDAO;
import com.example.demo.hbonetoonedemo.entity.Instructor;
import com.example.demo.hbonetoonedemo.entity.InstructorDetail;

@SpringBootApplication
public class HbOneToOneDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HbOneToOneDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO) {
		return runner -> {
			System.out.println("Welcome to hibernate");
			
			saveInstructor(instructorDAO);
			
			findInstructorById(instructorDAO);
			
			deleteInstructor(instructorDAO);
		};
	}

	private void saveInstructor(InstructorDAO instructorDAO) {
		Instructor instructor1 = new Instructor ("vamshi", "marripudi", "vamshi.marripudi@fmr.com");
		InstructorDetail instructorDetail1 = new InstructorDetail("I love coding", "music");
		
		Instructor instructor2 = new Instructor ("abbu", "paturi", "abbu.paturi@fmr.com");
		InstructorDetail instructorDetail2 = new InstructorDetail("I love coding", "dance");
		instructor1.setInstructorDetail(instructorDetail1);
		instructor2.setInstructorDetail(instructorDetail2);
		
		instructorDAO.save(instructor1);
		instructorDAO.save(instructor2);
		System.out.println("instructor & instructorDetail 1, 2 saved successfully");
	}
	
	private void findInstructorById(InstructorDAO instructorDAO) {
		int id = 2;
		Instructor instructor1 = instructorDAO.findInstructorById(id);
		
		System.out.println("found instructor : " +instructor1);
		System.out.println("instructor detail found : " +instructor1.getInstructorDetail());
	}
	
	private void deleteInstructor(InstructorDAO instructorDAO) {
		int id = 2;
		instructorDAO.deleteInstructorById(id);
		System.out.println("instructor deleted successfully");
	}
}
