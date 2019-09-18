package com.metacube.EADSession9.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.metacube.EADSession9.utils.*;
import com.metacube.EADSession9.entities.*;

@Component
public class FriendDAO {
	
	public static Database db = Database.getInstances();
	
	public List<Friend> getAllFriends(Integer emp_id) throws Exception{
		String query = "select id,name from employee where organization_id = (select organization_id from employee where id="+emp_id+") and id <> "+emp_id;
		ResultSet rs = db.getData(query);
		List<Friend> friend_list = new ArrayList<Friend>();
		while(rs.next()){
			Friend friend = new Friend();
			friend.setFriend_id(rs.getInt(1));
			friend.setFriend_name(rs.getString(2));
			friend_list.add(friend);
		}
		return friend_list;
	}
	
	public Friend getFriendProfile(Integer id) throws Exception{
		String query = "select emp.name,v.vehicle_number,emp.email,emp.contact from employee emp left join vehicle v on emp.id = v.emp_id where emp.id="+id;
		ResultSet rs = db.getData(query);
		Friend friend =new Friend();
		if(rs.next()){
			friend.setFriend_id(id);
			friend.setFriend_name(rs.getString(1));
			friend.setVehicle_number(rs.getString(2));
			friend.setEmail(rs.getString(3));
			friend.setContact(rs.getString(4));
			return friend;
		}
		return null;
	}
	

}
