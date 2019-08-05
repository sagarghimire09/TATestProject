package com.sagar.eRegistrar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.eRegistrar.model.Student;
import com.sagar.eRegistrar.repository.StudentRepository;
import com.sagar.eRegistrar.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository repository;
	
	@Override
	public Iterable<Student> getAllStudent() {
		return repository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public Student getStudentById(Integer studentId) {
		return repository.findById(studentId).orElse(null);
	}

	@Override
	public void deleteStudent(Student student) {
		repository.delete(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return repository.save(student);
	}

}
