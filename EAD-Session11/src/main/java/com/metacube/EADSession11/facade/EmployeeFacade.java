package com.metacube.EADSession11.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.EADSession11.DAO.EmployeeDAO;
import com.metacube.EADSession11.entities.Employee;

@Service
@Transactional
public class EmployeeFacade {
	
	@Autowired
	public EmployeeDAO empDao;
	
	public Employee getEmployee(Integer id) throws Exception{
		return empDao.getEmployee(id);
	}
	
	public List<Employee> getAllEmployeeOfSameOrganization(Integer org_id) throws Exception{
		return empDao.getAllEmployeeOfSameOrganization(org_id);
	}
	
	public void insertEmployee(Employee emp) throws Exception{
		empDao.insertEmployee(emp);
	}
	
	public Integer getLastInsertedEmpId() throws Exception{
		return empDao.getLastInsertedEmpId();
	}
	
	public Employee validUser(String email,String password) throws Exception{
		return empDao.validUser(email, password);
	}
	
	public void updateEmployee(Employee emp) throws Exception{
		empDao.updateEmployee(emp);
	}
}
