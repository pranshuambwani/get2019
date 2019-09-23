package com.metacube.EADSession11.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.EADSession11.DAO.FriendDAO;
import com.metacube.EADSession11.entities.Friend;

@Service
@Transactional
public class FriendFacade {
	
	@Autowired
	FriendDAO friendDao;

	public List<Friend> getAllFriends(Integer emp_id) throws Exception{
		return friendDao.getAllFriends(emp_id);
	}
	
	public Friend getFriendProfile(Integer id) throws Exception{
		return friendDao.getFriendProfile(id);
	}
}
