package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	Employee employee;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("register");
	}

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public ModelAndView signin() {
//		return new ModelAndView("login");
//	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView signup(@RequestParam("txtfname") String fname, @RequestParam("txtlname") String lname,
			@RequestParam("txtage") int age, @RequestParam("txtgender") String gender,
			@RequestParam("txtemail") String email, @RequestParam("txtaddress") String address,
			@RequestParam("txtpwd") String password, @RequestParam("txtrole") String role) {
		System.out.println(fname + lname + age + gender + email + address + password + role);

		employee = new Employee();
		employee.setFname(fname);
		employee.setLname(lname);
		employee.setAge(age);
		employee.setGender(gender);
		employee.setEmail(email);
		employee.setAddress(address);
		employee.setPassword(password);
		employee.setRole(role);
//		employeeService.createEmployee(employee);
		System.out.println("passed " + employee.getFname() + "details to empservice.");
		return new ModelAndView("login");
	}
//
//	@RequestMapping(value = "/home", method = RequestMethod.POST)
//	public ModelAndView signIn(@RequestParam("txtemail") String email) {
//		employee = new Employee();
//		employee.setEmail(email);
//		Employee ed = employeeService.getEmployee(employee);
//
//		if (ed == null) {
//			ModelAndView mv = new ModelAndView("login");
//			mv.addObject("msg", "Employee not found");
//			return mv;
//		} else {
//			return allEmployee();
//		}
//
//	}

//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public ModelAndView search(@RequestParam("txtemail") String email) {
//		employee = new Employee();
//		employee.setEmail(email);
//		Employee ed = employeeService.getEmployee(employee);
//
//		if (ed == null) {
//			ModelAndView mv = new ModelAndView("login");
//			mv.addObject("msg", "Employee not found");
//			return mv;
//		} else {
//			List<Employee> li = new ArrayList<Employee>();
//			li.add(ed);
//			return getEmployee(li);
//
//		}
//
//	}

	public ModelAndView getEmployee(List<Employee> li) {

		ModelAndView mv = new ModelAndView("home");
		mv.addObject("emplist", li);
		return mv;
	}

	public ModelAndView allEmployee() {

		List<Employee> li = employeeService.getEmployeeList();
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("emplist", li);
		return mv;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(Employee emp) {
		List<Employee> li = employeeService.deleteEmployee(emp.getEid());
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("msg", "Employee Deleted Successfully");
		mv.addObject("emplist", li);

		return mv;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editEmployee(@RequestParam("eid") int eid, @RequestParam("fname") String fname,
			@RequestParam("lname") String lname, @RequestParam("age") int age) {

		ModelAndView mv = new ModelAndView("employee-update");
//		mv.addObject("txteid",eid );
		// mv.addObject("txtfname",fname );
		// mv.addObject("txtlname",lname );
		// mv.addObject("txtage",age );

		return mv;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateEmployee(@RequestParam("txteid") int eid, @RequestParam("txtfname") String fname,
			@RequestParam("txtlname") String lname, @RequestParam("txtage") int age) {
		Employee emp = new Employee();
		emp.setEid(eid);
		emp.setFname(fname);
		emp.setLname(lname);
		emp.setAge(age);
		List<Employee> li = employeeService.updateEmployee(emp);
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("msg", "Employee Updated Successfully");
		mv.addObject("emplist", li);
		return mv;
	}

}