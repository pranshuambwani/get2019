package com.metacube.EADSession11.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.EADSession11.entities.Employee;

@Repository
public class EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;	
	
	public Employee getEmployee(Integer id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Employee emp = session.get(Employee.class,id);
		return emp;
	}
	
	public List<Employee> getAllEmployeeOfSameOrganization(Integer org_id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select * from Employee where organization_id="+org_id, Employee.class).getResultList();
	}
	
	public void insertEmployee(Employee emp){
		Session session = sessionFactory.getCurrentSession();
		session.save(emp);
	}
	
	public Integer getLastInsertedEmpId() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select max(id) from Employee", Integer.class).getSingleResult();
		
	}
	
	public Employee validUser(String email,String password) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Employee emp = session.createQuery("from Employee where email='"+email+"' and password='"+password+"'",Employee.class).getSingleResult();
		return emp; 
				    
	}
	
	public void updateEmployee(Employee emp) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(emp);
	}

}
