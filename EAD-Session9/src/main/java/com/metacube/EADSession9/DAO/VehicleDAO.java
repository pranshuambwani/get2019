package com.metacube.EADSession9.DAO;

import java.sql.ResultSet;

import org.springframework.stereotype.Component;

import com.metacube.EADSession9.utils.*;
import com.metacube.EADSession9.entities.*;

@Component
public class VehicleDAO {
	
	public static Database db = Database.getInstances();
	
	public  Integer insertVehicle(Vehicle vehicle) throws Exception{
		String query = "insert into vehicle(vehicle_name,type,vehicle_number,emp_id,identification) values("
				+ "'"+vehicle.getVehicle_name()+"','"+vehicle.getType()+"','"+vehicle.getVehicle_number()+"',"+vehicle.getEmp_id()+",'"+vehicle.getIdentification()+"')";
		return db.setData(query);
	}
	
	public  Integer getlastInsertedVehicleId() throws Exception{
		String query = "select max(id) from vehicle";
		ResultSet rs = (ResultSet) db.getData(query);
		if(rs.next())
			return rs.getInt(1);
		return 0;
	}
}
