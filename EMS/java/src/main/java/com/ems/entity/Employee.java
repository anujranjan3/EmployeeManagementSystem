package com.ems.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinTable;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Employee")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
	@Id
  
	private int eid;

	@Column(name = "FirstName")
	private String fname;
	@Column(name = "LastName")
	private String lname;
	@Column
	private int age;
	@Column
	private String gender;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String address;
	@Column
	private String role;
	@Column
	private int availableLeave;
	@Column
	private long phoneNumber;
	private Date loginTime;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname.toUpperCase();
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname.toUpperCase();
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender.toUpperCase();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.toUpperCase();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address.toUpperCase();
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role.toUpperCase();
	}
	public int getAvailableLeave() {
		return availableLeave;
	}
	public void setAvailableLeave(int availableLeave) {
		this.availableLeave = availableLeave;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Employee(int eid, String fname, String lname, int age, String gender, String email, String password,
			String address, String role, int availableLeave, long phoneNumber, Date loginTime) {
		super();
		this.eid = eid;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.address = address;
		this.role = role;
		this.availableLeave = availableLeave;
		this.phoneNumber = phoneNumber;
		this.loginTime = loginTime;
		
	}



}