package com.metacube.EADSession11.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="organization")
public class Organization {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@Column(name="Organization_name")
	String organization_name;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrganization_name() {
		return organization_name;
	}
	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}
	
	
}
