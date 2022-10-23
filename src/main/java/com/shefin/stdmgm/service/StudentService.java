package com.shefin.stdmgm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shefin.stdmgm.entity.Student;

@Service
public interface StudentService {
	
	List<Student> getAllStudents();
	Student saveStudent(Student student);
	Student getStudentById(int id);
	Student updateStudent(Student student);
	void removeStudentById(int id);

}
