package com.ems.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ems.entity.Employee;
import com.ems.entity.Manager;
@Repository
public interface EmployeeDao {
	public void createEmployee(Manager employee);

	public List<Employee> getEmployeeList();

	List<Employee> updateEmployee(Employee employee);

	List<Employee> deleteEmployee(int eid);

	Employee getEmployeeById(int eid);

	public ArrayList<Employee> getCredentialsOfAllEmployee();

	public List<String> employeeLogin(String email, String password);

	public void updateLoginTime(String email);


}
