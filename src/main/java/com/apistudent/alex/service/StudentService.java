package com.apistudent.alex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apistudent.alex.exception.NullPointerExceptionCustom;
import com.apistudent.alex.exception.StudentBadRequestException;
import com.apistudent.alex.exception.StudentNotFoundException;
import com.apistudent.alex.model.dto.ErrorMessageDto;
import com.apistudent.alex.model.entity.Student;
import com.apistudent.alex.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student findById(Long id) {
		return studentRepository.findById(id).get();
		
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

	public void trataException(Exception e) {
		
		if (e.getMessage().toUpperCase().contains("NOT FOUND") || e.getMessage().toUpperCase().contains("NO VALUE PRESENT")) {
			throw new StudentNotFoundException(e.getMessage());
			
		} else if (e.getMessage().toUpperCase().contains("REQUEST")) {
			throw new StudentBadRequestException(e.getMessage());
			
		} else {
			throw new NullPointerExceptionCustom(e.getMessage());
		}
	}
}



