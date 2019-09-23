package com.metacube.EADSession13Assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.EADSession13Assignment.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	public List<Student> findByFirstNameContainingIgnoreCase(String studentFirstName);
	
	public List<Student> findByEmailContainingIgnoreCase(String studentEmail);
}
