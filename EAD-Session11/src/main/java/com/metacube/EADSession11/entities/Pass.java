package com.metacube.EADSession11.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pass")
public class Pass {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	@Column(name="vehicle_id")
	Integer vehicle_id;
	@Column(name="emp_id")
	Integer emp_id;
	@Column(name="pass_type")
	String pass_type;
	@Column(name="Rate")
	String rate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(Integer vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public Integer getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getPass_type() {
		return pass_type;
	}
	public void setPass_type(String pass_type) {
		this.pass_type = pass_type;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	

}
