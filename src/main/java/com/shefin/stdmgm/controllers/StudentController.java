package com.shefin.stdmgm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shefin.stdmgm.entity.Student;
import com.shefin.stdmgm.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;

	
	@GetMapping("/students")
	public String getListOfStudent(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students-list-view";
	}
	
	@GetMapping("/students/new")
	public String createNewEntry(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		
		return "create-new-entry";
		
	}
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student ) {
		studentService.saveStudent(student);
		return "redirect:/students";
		
	}
	
	@GetMapping("students/edit/{id}")
	public String editStudent(@PathVariable int id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "edit-student";
	}
	
	@PostMapping("/save/{id}")
	public String saveEdittedStudent(@PathVariable int id, @ModelAttribute("student") Student student, Model model) {
		Student exStudent = studentService.getStudentById(id);
		exStudent.setFirstName(student.getFirstName());
		exStudent.setLastName(student.getLastName());
		exStudent.setEmail(student.getEmail());
		studentService.updateStudent(exStudent);
		return "redirect:/students";
		
	}
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.removeStudentById(id);
		return "redirect:/students";
		
	}
	
	

}
