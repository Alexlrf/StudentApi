package com.apistudent.alex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apistudent.alex.model.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Optional<Student> findById(Long id);
	List<Student> findAll();

}
