package com.metacube.EADSession9.entities;

import javax.validation.constraints.NotBlank;

public class Vehicle {
	
	Integer id;
	@NotBlank(message="Field cannot be blank")
	String vehicle_name;
	String type;
	@NotBlank(message="Field cannot be blank")
	String vehicle_number;
	Integer emp_id;
	@NotBlank(message="Field cannot be blank")
	String Identification;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVehicle_name() {
		return vehicle_name;
	}
	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVehicle_number() {
		return vehicle_number;
	}
	public void setVehicle_number(String vehicle_number) {
		this.vehicle_number = vehicle_number;
	}
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getIdentification() {
		return Identification;
	}
	public void setIdentification(String identification) {
		Identification = identification;
	}
	
	

}
