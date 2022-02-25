package com.apistudent.alex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apistudent.alex.model.entity.EntityWithRevisions;
import com.apistudent.alex.model.entity.Student;
import com.apistudent.alex.repository.GenericRevisionRepository;

@Service
public class GenericRevisionService {

	@Autowired
	private GenericRevisionRepository<Student> genericRevisionRepository;

	public List<EntityWithRevisions<Student>> listRevisions(Long idStudent, Class<Student> studentClass) {
		return genericRevisionRepository.listRevisions(idStudent, studentClass);
	}

}
