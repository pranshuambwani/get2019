package com.metacube.EADSession9.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;






import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.metacube.EADSession9.utils.Database;
import com.metacube.EADSession9.entities.Employee;

@Component
public class EmployeeDAO {
	
	public static Database db = Database.getInstances();
	
	public Employee getEmployee(Integer id) throws Exception{
		ResultSet rs = db.getData("select * from employee where id="+id);
		Employee emp = new Employee();
		if(rs.next()){
			emp.setEmp_id(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setGender(rs.getString(3));
			emp.setEmail(rs.getString(4));
			emp.setContact(rs.getString(6));
			emp.setOrganization_id(rs.getInt(7));
		}
		return emp;
	}
	
	public List<Employee> getAllEmployeeOfSameOrganization(Integer org_id) throws Exception{
		ResultSet rs = db.getData("select * from employee where organization_id="+org_id);
		List<Employee> emp_list = new ArrayList<Employee>();
		while(rs.next()){
			Employee emp = new Employee();
			emp.setEmp_id(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setGender(rs.getString(3));
			emp.setEmail(rs.getString(4));
			emp.setContact(rs.getString(6));
			emp.setOrganization_id(rs.getInt(7));
			emp_list.add(emp);
		}
		return emp_list;
	}
	
	public Integer insertEmployee(Employee emp) throws Exception{
		String query = "insert into employee(name,gender,email,password,contact,organization_id) values"
				+ "('"+emp.getName()+"','"+emp.getGender()+"','"+emp.getEmail()+"','"+emp.getPassword()+"','"+emp.getContact()+"',"+emp.getOrganization_id()+")";
		ResultSet rs = db.getData("select * from employee where email='"+emp.getEmail()+"'");
		if(rs.next())
			return 0;
		else{
			return db.setData(query);
		}
	}
	
	public Integer getLastInsertedEmpId() throws Exception{
		String query = "select max(id) from employee";
		ResultSet rs = db.getData(query);
		if(rs.next())
			return rs.getInt(1);
		else
			return 0;
	}
	
	public Employee validUser(String email,String password) throws Exception{
		String query = "select * from employee where email='"+email+"' and password='"+password+"'";
		ResultSet rs = db.getData(query);
		if(rs.next()){
			Employee employee = new Employee();
			employee.setEmp_id(rs.getInt(1));
			employee.setName(rs.getString(2));
			employee.setGender(rs.getString(3));
			employee.setEmail(email);
			employee.setContact(rs.getString(6));
			employee.setOrganization_id(rs.getInt(7));
			return employee;
		}
		return null;
	}
	
	public Integer updateEmployee(Employee emp) throws Exception{
		String query = "update employee set name='"+emp.getName()+"',gender='"+emp.getGender()+"',email='"+emp.getEmail()+"',contact='"+emp.getContact()+"',organization_id="+emp.getOrganization_id()+" where id="+emp.getEmp_id();
		return db.setData(query);
	}

}
