package com.metacube.EADSession9.Facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.EADSession9.DAO.PassDAO;
import com.metacube.EADSession9.entities.Pass;

@Component
public class PassFacade {
	
	@Autowired
	PassDAO passDao;
	
	public Integer insertPass(Pass pass) throws Exception{
		return passDao.insertPass(pass);
	}
	

}
