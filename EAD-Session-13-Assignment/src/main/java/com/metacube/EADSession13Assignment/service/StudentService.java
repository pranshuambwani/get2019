package com.metacube.EADSession13Assignment.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.EADSession13Assignment.entity.StudentEntity;

@Service
public interface StudentService {

	void insertData(StudentEntity sObj);

	public List<StudentEntity> getAll();

	List<StudentEntity> duplicateEmail(StudentEntity sObj);

	List<StudentEntity> findByID(StudentEntity map);


}
