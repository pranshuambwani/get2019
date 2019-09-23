package com.metacube.EADSession9.DAO;

import org.springframework.stereotype.Component;

import com.metacube.EADSession9.utils.*;
import com.metacube.EADSession9.entities.*;

@Component
public class PassDAO {
	
	public static Database db = Database.getInstances();
	
	public Integer insertPass(Pass pass) throws Exception{
		
		String query = "insert into pass(vehicle_id,emp_id,pass_type,rate) values("
				+ pass.getVehicle_id() +","+pass.getEmp_id()+",'"+pass.getPass_type()+"','"+pass.getRate()+"')";
		
		return db.setData(query);
		
	}

}
