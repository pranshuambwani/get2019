package com.metacube.EADSession9.Facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.EADSession9.DAO.VehicleDAO;
import com.metacube.EADSession9.entities.Vehicle;

@Component
public class VehicleFacade {
	
	@Autowired
	VehicleDAO vehicleDao;
	
	public  Integer insertVehicle(Vehicle vehicle) throws Exception{
		return vehicleDao.insertVehicle(vehicle);
	}
	
	public  Integer getlastInsertedVehicleId() throws Exception{
		return vehicleDao.getlastInsertedVehicleId();
	}

}
