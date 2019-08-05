package com.sagar.eRegistrar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sagar.eRegistrar.model.Student;
import com.sagar.eRegistrar.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService service;
	
	@GetMapping("/eregistrar/student/list")
	public String listStudent(ModelMap model) {
		model.addAttribute("students",service.getAllStudent());
		return "student/list";
	}
	
	@GetMapping("/eregistrar/student/create")
	public String showCreate(Model model) {
		model.addAttribute("student",new Student());
		return "student/create";
	}
	
	@PostMapping("/eregistrar/student/save")
	public String saveStudent(@Valid @ModelAttribute("student")Student student, 
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "student/create";
		}
		Student savedStudent = service.saveStudent(student);
		return "redirect:/eregistrar/student/list";
	}
	
	@GetMapping("/eregistrar/student/edit/{studentId}")
	public String editStudent(@PathVariable Integer studentId, Model model) {
		Student student = service.getStudentById(studentId);
		if(student != null) {
			model.addAttribute(student);
			return "student/edit";
		}
		return "student/edit";
	}
	
	@PostMapping("/eregistrar/student/update")
	public String updateStudent(@Valid @ModelAttribute("student")Student student,
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors",bindingResult.getAllErrors());
			return "student/edit";
		}
		Student updatedStudent = service.updateStudent(student);
		return "redirect:/eregistrar/student/list";
	}
	
	@GetMapping("/eregistrar/student/delete/{studentId}")
	public String deleteStudent(@PathVariable Integer studentId) {
		Student st = service.getStudentById(studentId);
		if(st != null) {
			service.deleteStudent(st);
		}
		return "redirect:/eregistrar/student/list";
	}
}
