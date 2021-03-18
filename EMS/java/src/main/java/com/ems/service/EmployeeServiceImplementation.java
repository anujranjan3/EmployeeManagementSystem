package com.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.EmployeeDao;
import com.ems.entity.Employee;
import com.ems.entity.Manager;

@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void createEmployee( Manager employee) {
		employeeDao.createEmployee(employee);

	}

	@Override
	public List<Employee> getEmployeeList() {

		return employeeDao.getEmployeeList();
	}

	

	@Override
	public List<Employee> updateEmployee(Employee employee) {

		return employeeDao.updateEmployee(employee);
	}

	@Override
	public List<Employee> deleteEmployee(int eid) {

		return employeeDao.deleteEmployee(eid);
	}

	@Override
	public Employee getEmployeeById(int eid) {
		return employeeDao.getEmployeeById(eid);

	}

	@Override
	public ArrayList<Employee> getCredentialsOfAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.getCredentialsOfAllEmployee();
	}


	@Override
	public List<String> employeeLogin(String email, String password) {
		// TODO Auto-generated method stub
		return employeeDao.employeeLogin(email.toUpperCase(),password);  
	}

	@Override
	public void updateLoginTime(String email) {
		employeeDao.updateLoginTime(email);
		
	}



}