package com.ems.dao;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.entity.Employee;
import com.ems.entity.Manager;

@Repository

public class EmployeeDaoImplementation implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void createEmployee(Manager manager) {

		manager.setAvailableLeave(24);
		manager.setLoginTime(new Date());

		if (manager.getRole().equals("MANAGER")) {

			getSession().saveOrUpdate(manager);

		} else {
			Employee employee = new Employee();
			employee.setAddress(manager.getAddress());
			employee.setAge(manager.getAge());
			employee.setEid(manager.getEid());
			employee.setEmail(manager.getEmail());
			employee.setFname(manager.getFname());
			employee.setGender(manager.getGender());
			employee.setLname(manager.getLname());
			employee.setPassword(manager.getPassword());
			employee.setRole(manager.getRole());
			employee.setAvailableLeave(24);
			employee.setPhoneNumber(manager.getPhoneNumber());
			employee.setLoginTime(new Date());
			getSession().saveOrUpdate(employee);
		}

	}

	@Override
	public List<Employee> getEmployeeList() {
		Query query = getSession().createQuery("select me from Employee me");
		@SuppressWarnings("unchecked")
		List<Employee> empList = query.list();
		return empList;
	}

	@Override
	public Employee getEmployeeById(int eid) {
		Query query = getSession().createQuery("from Employee me where eid=" + eid);
		Employee e = (Employee) query.uniqueResult();
		return e;
	}

	@Override
	public List<Employee> updateEmployee(Employee employee) {
		int eid = employee.getEid();
		int age = employee.getAge();
		String fname = employee.getFname().toUpperCase();
		String lname = employee.getLname().toUpperCase();
		String gender = employee.getGender().toUpperCase();
		String email = employee.getEmail().toUpperCase();
		long phoneNumber = employee.getPhoneNumber();
		String address = employee.getAddress().toUpperCase();

		Query query = getSession().createQuery(
				"update Employee em set fname=:fname, lname=:lname, age=:age,gender=:gender,email=:email,phoneNumber=:phoneNumber,address=:address where eid=:eid");
		query.setParameter("eid", eid);
		query.setParameter("fname", fname);
		query.setParameter("lname", lname);
		query.setParameter("age", age);
		query.setParameter("gender", gender);
		query.setParameter("email", email);
		query.setParameter("phoneNumber", phoneNumber);
		query.setParameter("address", address);

		query.executeUpdate();
		return getEmployeeList();
	}

	@Override
	public List<Employee> deleteEmployee(int eid) {
		Query query = getSession().createQuery("delete from Employee em where eid=:eid");
		query.setParameter("eid", eid);
		query.executeUpdate();
		return getEmployeeList();
	}

	@Override
	public ArrayList<Employee> getCredentialsOfAllEmployee() {
		Query query = getSession().createQuery("select email,password from Employee me");
		@SuppressWarnings("unchecked")
		ArrayList<Employee> empList = (ArrayList<Employee>) query.list();
		return empList;
	}

	@Override
	public List<String> employeeLogin(String email, String password) {
		Query query = getSession().createQuery(
				"select role from Employee  where email='" + email + "'and password='" + password + "'");
		Query query1 = getSession().createQuery(
				"select fname from Employee  where email='" + email + "'and password='" + password + "'");
		Query query3 = getSession().createQuery(
				"select loginTime from Employee  where email='" + email + "'and password='" + password + "'");
		Query query4 = getSession().createQuery(
				"select eid from Employee  where email='" + email + "'and password='" + password + "'");
		Query query5 = getSession().createQuery(
				"select availableLeave from Employee  where email='" + email + "'and password='" + password + "'");
		
		String e = (String) query.uniqueResult();
		String fname=(String)query1.uniqueResult();
		Date loginTime=(Date) query3.uniqueResult();
		int  eidd=(int) query4.uniqueResult();
		int avail=(int)query5.uniqueResult();
		String id=String.valueOf(eidd);
		String availableLave=String.valueOf(avail);
		List<String> list = new ArrayList<String>();
		list.add(e);
		list.add(email);
		list.add(fname);
		
		if(!(loginTime==null)) {
		list.add(loginTime.toString());}
		else {
			list.add("First Login");
		}
		list.add(id);
		list.add(availableLave);
		
		return (list);
	}

	@Override
	public void updateLoginTime(String email) {
		Query query=getSession().createSQLQuery("CALL updateTime(:email)");

		query.setParameter("email", email);
		query.executeUpdate();
		
	}

	

}
