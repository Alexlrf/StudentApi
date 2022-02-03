package com.apistudent.alex.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.apistudent.alex.entity.Student;
import com.apistudent.alex.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
		
	}
	
	public Student save(Student student) {
		return studentRepository.save(student);
		
	}

	public void deleteById(Long id) {
		studentRepository.deleteById(id);;
		
	}
	
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
}
