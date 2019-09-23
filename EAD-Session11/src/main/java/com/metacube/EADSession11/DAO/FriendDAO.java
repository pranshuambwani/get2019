package com.metacube.EADSession11.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.EADSession11.entities.Friend;


@Repository
public class FriendDAO {
	
	@Autowired
	private SessionFactory sessionFactory;	
	
	
	public List<Friend> getAllFriends(Integer emp_id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		String query = "select id,name from Employee where organization_id = (select organization_id from Employee where id="+emp_id+") and id <> "+emp_id;
		Query query1 = session.createQuery(query);
		List<Object[]> collection1 = query1.getResultList();
		List<Friend> frndList = new ArrayList<Friend>();
		for(Object[] user: collection1)
		 {
			Friend frnd = new Friend();
			frnd.setFriend_id((Integer)user[0]);
			frnd.setFriend_name((String)user[1]);
			frndList.add(frnd);
		 }
		return frndList;
	}
	
	public Friend getFriendProfile(Integer id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		String query = "select emp.name,v.vehicle_number,emp.email,emp.contact from Employee emp left join Vehicle v on emp.id = v.emp_id where emp.id="+id;
		Query query1 = session.createQuery(query);
		List<Object[]> collection1 = query1.getResultList();
		Friend frnd = new Friend();
		for(Object[] user: collection1)
		 {
			frnd.setFriend_name((String)user[0]);
			frnd.setVehicle_number((String)user[1]);
			frnd.setEmail((String)user[2]);
			frnd.setContact((String)user[3]);
		 }
		
		return frnd;
	}
	

}
