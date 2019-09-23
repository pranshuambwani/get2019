package com.metacube.EADSession11.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.EADSession11.DAO.OrganizationDAO;
import com.metacube.EADSession11.entities.Organization;


@Service
@Transactional
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
