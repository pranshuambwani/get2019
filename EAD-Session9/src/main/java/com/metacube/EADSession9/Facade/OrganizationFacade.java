package com.metacube.EADSession9.Facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.EADSession9.DAO.OrganizationDAO;
import com.metacube.EADSession9.entities.Organization;

@Component
public class OrganizationFacade {

	@Autowired
	OrganizationDAO orgDao;
	
	public Organization getOrganization(Integer id) throws Exception{
		return orgDao.getOrganization(id);
	}
	
	public List<Organization> getAllOrganization() throws Exception{
		return orgDao.getAllOrganization();
	}
}
