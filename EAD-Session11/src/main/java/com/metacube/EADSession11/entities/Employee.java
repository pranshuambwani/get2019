package com.metacube.EADSession11.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;
@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	@NotBlank(message="Field Can't be empty")
	@Column(name="name")
	String name;
	@NotBlank(message="Field Can't be empty")
	@Column(name="gender")
	String gender;
	
	@NotBlank(message="Field Can't be empty")
	@Column(name="email",unique=true,insertable=true,updatable=true)
	String email;
	
	@NotBlank(message="Field Can't be empty")
	@Column(name="Password")
	String password;
	
	String cpassword;
	
	@NotBlank(message="Field Can't be empty")
	@Size(min=10 , max=10 , message="Should be 10 digit")
	@Column(name="contact")
	String contact;
	@Column(name="Organization_id")
	Integer organization_id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Integer getOrganization_id() {
		return organization_id;
	}
	public void setOrganization_id(Integer organization_id) {
		this.organization_id = organization_id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	@Override
	public String toString() {
		return "Employee [emp_id=" + id + ", name=" + name + ", gender="
				+ gender + ", email=" + email + ", password=" + password
				+ ", contact=" + contact
				+ ", organization_id=" + organization_id + "]";
	}
	
	
	

}
