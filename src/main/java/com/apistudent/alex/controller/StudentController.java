package com.apistudent.alex.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apistudent.alex.entity.EntityWithRevisions;
import com.apistudent.alex.entity.Student;
import com.apistudent.alex.repository.GenericRevisionRepository;
import com.apistudent.alex.service.StudentService;
import com.apistudent.alex.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping(value="/studentApi")
public class StudentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private GenericRevisionRepository genericRevisionRepository;

	@GetMapping(value = "/test")
	public String getTestMessages() {
		return "Tudo OK!";

	}
	
	@GetMapping(value = "/students")
	public List<Student> findAll() {
		
		return studentService.findAll();

	}

	@PostMapping(value = "/student")
	public ResponseEntity<Student> save(@RequestBody Student student) {

		HttpHeaders headers = null;

		try {
			headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");

			studentService.save(student);

		} catch (Exception e) {
			try {
				LOGGER.info("Erro Response - " + Utils.createJson(student) + " - " + e.getMessage() );
			} catch (JsonProcessingException e1) {
				e1.getMessage();
			}
			return new ResponseEntity<Student>(null, headers, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().headers(headers).body(student);

	}

	@PutMapping(value = "/student")
	public ResponseEntity<Student> changeStudent(@RequestBody Student student) {

		HttpHeaders headers = null;

		try {
			headers = new HttpHeaders();
			headers.add("Content-Type", "application/json");

			studentService.save(student);

		} catch (Exception e) {
			try {
				LOGGER.info("Erro Response - " + Utils.createJson(student));
			} catch (JsonProcessingException e1) {
				e1.printStackTrace();
			}
			return new ResponseEntity<Student>(null, headers, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().headers(headers).body(student);

	}

	@DeleteMapping(value = "/student/{id}")
	public String delete(@PathVariable Long id) {
		studentService.deleteById(id);
		return "Student deleted!";

	}

	/* BUSCA DAS TABELAS AUDITED */

	@GetMapping(value = "/changesLog/{id}")
	public ResponseEntity<List<EntityWithRevisions<Student>>>  getLogMessages(@PathVariable Long id) {
		
		Optional<Student> stududentAudited = studentService.findById(id);		
		List<EntityWithRevisions<Student>> listRevisions = genericRevisionRepository.listRevisions(stududentAudited.get().getIdStudent(), Student.class);

		if (listRevisions != null) {
			return new ResponseEntity<List<EntityWithRevisions<Student>>>(listRevisions, HttpStatus.OK);
		} else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
