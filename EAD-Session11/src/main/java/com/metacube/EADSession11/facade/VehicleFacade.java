package com.metacube.EADSession11.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.EADSession11.DAO.VehicleDAO;
import com.metacube.EADSession11.entities.Vehicle;

@Service
@Transactional
public class VehicleFacade {
	
	@Autowired
	VehicleDAO vehicleDao;
	
	public  void insertVehicle(Vehicle vehicle) throws Exception{
		vehicleDao.insertVehicle(vehicle);
	}
	
	public  Integer getlastInsertedVehicleId() throws Exception{
		return vehicleDao.getlastInsertedVehicleId();
	}

}
