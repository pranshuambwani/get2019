package com.metacube.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.metacube.parkingsystem.Database;
import com.metacube.services.Organization;

public class OrganizationDAO {
	
	public static Database db = Database.getInstances();
	
	public static Organization getOrganization(Integer id) throws Exception{
		String query = "select * from organization where id="+id;
		ResultSet rs = db.getData(query);
		Organization org = new Organization();
		if(rs.next()){
			org.setId(rs.getInt(1));
			org.setOrganization_name(rs.getString(2));
		}
		return org;		
	}
	
	public static List<Organization> getAllOrganization() throws Exception{
		ResultSet rs = db.getData("select * from organization");
		List<Organization> org_list = new ArrayList<Organization>();
		while(rs.next()){
			Organization org = new Organization();
			org.setId(rs.getInt(1));
			org.setOrganization_name(rs.getString(2));
			org_list.add(org);
		}
		return org_list;
	}	

}
