package com.ems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.entity.Employee;
import com.ems.entity.Manager;
@Service
@Transactional
public interface EmployeeService {
	public void createEmployee( Manager employee);

	public List<Employee> getEmployeeList();

	

	public List<Employee> updateEmployee(Employee employee);

	public List<Employee> deleteEmployee(int eid);

	public Employee getEmployeeById(int eid);
	public ArrayList<Employee> getCredentialsOfAllEmployee();

	

	public List<String> employeeLogin(String email,String password);

	public void updateLoginTime(String email);

	
	

}