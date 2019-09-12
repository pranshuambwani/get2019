package com.metacube.EADSession8.entities;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class Student {
	@NotEmpty(message="{field.empty}")
	@Pattern(regexp="[A-Z a-z]*",message="{name.validation}")
	String first_name;
	
	@NotEmpty(message="{field.empty}")
	@Pattern(regexp="[A-Z a-z]*",message="{name.validation}")
	String last_name;
	
	@NotEmpty(message="{field.empty}")
	@Pattern(regexp="[A-Z a-z]*",message="{name.validation}")
	String father_name;
	
	@NotEmpty(message="{field.empty}")
	@Email(message="{email.validation}")
	String email;
	
	@NotEmpty(message="{field.empty}")
	String student_class;
	
	@NotNull(message="{field.empty}")
	@Min(value=1,message="{min.age}")
	@Max(value=50,message="{max.age}")
	Integer age;
	
	
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStudent_class() {
		return student_class;
	}
	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [first_name=" + first_name + ", last_name=" + last_name
				+ ", father_name=" + father_name + ", email=" + email
				+ ", student_class=" + student_class + ", age=" + age + "]";
	}
	
	
}
