package com.apistudent.alex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apistudent.alex.exception.StudentBadRequestException;
import com.apistudent.alex.exception.StudentNotFoundException;
import com.apistudent.alex.model.entity.Student;
import com.apistudent.alex.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public Student findById(String id) {
		
		Long validId;
		if ((null == id || id.isEmpty()) 
				|| Character.isLetter(id.charAt(id.length() - 1))) {
			throw new StudentBadRequestException("Invalid parameters");
		} else {
			validId = Long.valueOf(id);
		}		
		return studentRepository.findById(validId).
				orElseThrow(() -> new StudentNotFoundException("Student not found"));
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

	public Student findWithBody(Student student) {
		
		if((null == student.getFirstname() || student.getFirstname().isEmpty())
				&& null == student.getMaritalStatus()) {
			throw new StudentBadRequestException("Properties 'firstname'  and  'maritalStatus'  are required");
		}else if (null == student.getFirstname() || student.getFirstname().isEmpty()) {
			throw new StudentBadRequestException("Property 'firstname' is required");
		} else if (null == student.getMaritalStatus()){
			throw new StudentBadRequestException("Property 'maritalStatus' is required");
		} 
			
		Student studentFound = studentRepository.findByFirstnameAndMaritalStatus(student.getFirstname(), student.getMaritalStatus());
		
		if (studentFound != null) {
			return studentFound;
		} else {
			throw new StudentNotFoundException("Student not found");
		}
				 	
	}

//	public void trataException(Exception e) {
//		
//		if (e.getMessage().toUpperCase().contains("NOT FOUND") || e.getMessage().toUpperCase().contains("NO VALUE PRESENT")) {
//			throw new StudentNotFoundException(e.getMessage());
//			
//		} else if (e.getMessage().toUpperCase().contains("REQUEST")) {
//			throw new StudentBadRequestException(e.getMessage());
//			
//		} else {
//			throw new NullPointerExceptionCustom(e.getMessage());
//		}
//	}
}



