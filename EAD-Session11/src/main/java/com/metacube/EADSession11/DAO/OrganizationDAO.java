package com.metacube.EADSession11.DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.metacube.EADSession11.entities.Organization;
@Repository
public class OrganizationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
		
	public Organization getOrganization(Integer id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Organization org = session.get(Organization.class,id);
		return org;		
	}
	
	public List<Organization> getAllOrganization() throws Exception{
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Organization",Organization.class).getResultList();
	}	

}
