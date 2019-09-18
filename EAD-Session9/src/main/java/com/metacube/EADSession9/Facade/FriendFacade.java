package com.metacube.EADSession9.Facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.EADSession9.DAO.FriendDAO;
import com.metacube.EADSession9.entities.Friend;

@Component
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
