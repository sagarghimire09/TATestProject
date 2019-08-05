package com.sagar.eRegistrar.service;

import com.sagar.eRegistrar.model.Student;

public interface StudentService {
	Iterable<Student> getAllStudent();
	Student saveStudent(Student student);
	Student getStudentById(Integer studentId);
	void deleteStudent(Student student);
	Student updateStudent(Student student);
}
