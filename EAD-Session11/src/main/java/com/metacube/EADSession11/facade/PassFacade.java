package com.metacube.EADSession11.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.EADSession11.DAO.PassDAO;
import com.metacube.EADSession11.entities.Pass;

@Transactional
@Service
public class PassFacade {
	
	@Autowired
	PassDAO passDao;
	
	public void insertPass(Pass pass) throws Exception{
		 passDao.insertPass(pass);
	}
	

}
