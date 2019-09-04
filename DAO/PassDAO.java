package com.metacube.DAO;

import com.metacube.parkingsystem.Database;
import com.metacube.services.Pass;

public class PassDAO {
	
	public static Database db = Database.getInstances();
	
	public static Integer insertPass(Pass pass) throws Exception{
		
		String query = "insert into pass(vehicle_id,emp_id,pass_type,rate) values("
				+ pass.getVehicle_id() +","+pass.getEmp_id()+",'"+pass.getPass_type()+"','"+pass.getRate()+"')";
		
		return db.setData(query);
		
	}

}
