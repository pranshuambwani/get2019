package com.metacube.EADSession13Assignment.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.EADSession13Assignment.dao.StudentDao;
import com.metacube.EADSession13Assignment.entity.StudentEntity;

@Service
public class StudentServiceImp implements StudentService{
	@Autowired
	StudentDao studentdaoObj;
	@Override
	public void insertData(StudentEntity sObj) {
		studentdaoObj.add(sObj);
		
	}
	@Override
	public List<StudentEntity> getAll() {
		return studentdaoObj.getAll();
	}
	@Override
	public List<StudentEntity> duplicateEmail(StudentEntity sObj) {
		return studentdaoObj.duplicateEmail(sObj);
	}
	@Override
	public List<StudentEntity> findByID(StudentEntity sObj) {
		return studentdaoObj.findByID(sObj);
	}

}
