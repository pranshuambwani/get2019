package com.metacube.EADSession13Assignment.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.metacube.EADSession13Assignment.entity.StudentEntity;

@Transactional
@Component
public class StudentDao {

	@Autowired
	HibernateTemplate template;

	public StudentDao() {
		
	}

	@Autowired
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}


	public List<StudentEntity> getAll(){
		return template.loadAll(StudentEntity.class);
	}
	
	
	public int add(StudentEntity sObj) {
		return (int) template.save(sObj);
	}

	public List<StudentEntity> duplicateEmail(StudentEntity sObj) {
		return template.findByExample(sObj);
	}

	public List<StudentEntity> findByID(StudentEntity sObj) {
		return template.findByExample(sObj);
	}
	
}