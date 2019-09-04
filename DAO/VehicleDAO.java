package com.metacube.DAO;

import com.metacube.parkingsystem.Database;
import com.metacube.services.Vehicle;
import com.mysql.jdbc.ResultSet;

public class VehicleDAO {
	
	public static Database db = Database.getInstances();
	
	public static Integer insertVehicle(Vehicle vehicle) throws Exception{
		String query = "insert into vehicle(vehicle_name,type,vehicle_number,emp_id,identification) values("
				+ "'"+vehicle.getVehicle_name()+"','"+vehicle.getType()+"','"+vehicle.getVehicle_number()+"',"+vehicle.getEmp_id()+",'"+vehicle.getIdentification()+"')";
		return db.setData(query);
	}
	
	public static Integer getlastInsertedVehicleId() throws Exception{
		String query = "select max(id) from vehicle";
		ResultSet rs = (ResultSet) db.getData(query);
		if(rs.next())
			return rs.getInt(1);
		return 0;
	}
}
