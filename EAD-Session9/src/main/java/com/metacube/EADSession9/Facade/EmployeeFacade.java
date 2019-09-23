package com.metacube.EADSession9.Facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.EADSession9.DAO.EmployeeDAO;
import com.metacube.EADSession9.entities.Employee;

@Component
public class EmployeeFacade {
	
	@Autowired
	public EmployeeDAO empDao;
	
	public Employee getEmployee(Integer id) throws Exception{
		return empDao.getEmployee(id);
	}
	
	public List<Employee> getAllEmployeeOfSameOrganization(Integer org_id) throws Exception{
		return empDao.getAllEmployeeOfSameOrganization(org_id);
	}
	
	public Integer insertEmployee(Employee emp) throws Exception{
		return empDao.insertEmployee(emp);
	}
	
	public Integer getLastInsertedEmpId() throws Exception{
		return empDao.getLastInsertedEmpId();
	}
	
	public Employee validUser(String email,String password) throws Exception{
		return empDao.validUser(email, password);
	}
	
	public Integer updateEmployee(Employee emp) throws Exception{
		return empDao.updateEmployee(emp);
	}
}
