package com.shefin.stdmgm;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shefin.stdmgm.entity.Student;
import com.shefin.stdmgm.repo.StudentRepo;

@SpringBootApplication
public class StudentManagementSystemApplication {

	@Autowired
	private StudentRepo studentRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		
		studentRepo.save(new Student("shefin", "shareef", "shefin@gmail.com"));
		studentRepo.save(new Student("shiya", "shareef", "shiya@gmail.com"));
		studentRepo.save(new Student("sharmina", "shareef", "sharmina@gmail.com"));
		studentRepo.save(new Student("shareef", "vadakkayil", "shareef@gmail.com"));
		
	}

}
