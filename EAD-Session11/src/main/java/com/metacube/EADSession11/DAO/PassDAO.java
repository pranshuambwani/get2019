package com.metacube.EADSession11.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.EADSession11.entities.Pass;


@Repository
public class PassDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertPass(Pass pass) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		session.save(pass);
	}

}
