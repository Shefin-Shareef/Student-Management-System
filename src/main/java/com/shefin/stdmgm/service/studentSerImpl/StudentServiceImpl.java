package com.shefin.stdmgm.service.studentSerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shefin.stdmgm.entity.Student;
import com.shefin.stdmgm.repo.StudentRepo;
import com.shefin.stdmgm.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo studentRepo;
	
	public StudentServiceImpl(StudentRepo studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
		
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepo.save(student);
		return student;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		return studentRepo.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentRepo.save(student);
		return student;
	}

	@Override
	public void removeStudentById(int id) {
		// TODO Auto-generated method stub
		Student student = studentRepo.findById(id).get();
		studentRepo.delete(student);
		
	}
	
	

}
