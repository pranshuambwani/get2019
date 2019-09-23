package com.metacube.EADSession11.DAO;

import java.sql.ResultSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.EADSession11.entities.Vehicle;

@Repository
public class VehicleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
		
	
	public  void insertVehicle(Vehicle vehicle) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(vehicle);
	}
	
	public  Integer getlastInsertedVehicleId() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select max(id) from Vehicle", Integer.class).getSingleResult();
		
	}
}
