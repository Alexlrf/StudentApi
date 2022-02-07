package com.apistudent.alex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
		String idWithoutNumbers = id.replaceAll("\\d", "");
		
		if (!ObjectUtils.isEmpty(idWithoutNumbers)) {
			throw new StudentBadRequestException("Invalid parameters");
		} else {
			validId = Long.valueOf(id);
		}		
		return studentRepository.findById(validId).
				orElseThrow(() -> new StudentNotFoundException("Student not found"));
	}
	
//	public Student save(Student student) {
//		
//		if(null == student.getFirstname() || student.getFirstname().isEmpty()) {
//			throw new StudentBadRequestException("Property 'firstname'is required");
//		} else if (null == student.getLastname() || student.getLastname().isEmpty()) {
//			throw new StudentBadRequestException("Property 'lastname' is required");
//		} else if (null == student.getEmail() || student.getEmail().isEmpty()) {
//			throw new StudentBadRequestException("Property 'email' is required");
//		} else if (null == student.getPhone() || student.getPhone().isEmpty()) {
//			throw new StudentBadRequestException("Property 'phone' is required");
//		} else if (null == student.getMaritalStatus()){
//			throw new StudentBadRequestException("Property 'maritalStatus' is required");
//		}
//		return studentRepository.save(student);
//	}
	
	public Student save(Student student) {
		
		return studentRepository.save(student);
	}

	public String deleteById(String id) {
		
		Long validId;
		
		if ((null == id || id.isEmpty()) || Character.isLetter(id.charAt(id.length() - 1))) {
			throw new StudentBadRequestException("Invalid parameters");
		} else {
			validId = Long.valueOf(id);
		}
		
		try {
			studentRepository.deleteById(validId);
			
		} catch (Exception e) {
			throw new StudentNotFoundException("Student not found");
		}
		return "Student deleted";
		
	}
	
	public List<Student> findAll() {
		
		List<Student> studentsList = studentRepository.findAll();
		
		if (null == studentsList || studentsList.isEmpty()) {
			throw new StudentBadRequestException("No records found to search");
		} else {
			return studentsList;
		}
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
}



