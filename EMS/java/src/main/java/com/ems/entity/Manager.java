package com.ems.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



@Entity
@Table(name = "MANAGER")
@OnDelete(action = OnDeleteAction.CASCADE)
public class Manager extends Employee {

	private int totalLeaveApproved;
	private int totalLeaveRejected;
	

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int eid, String fname, String lname, int age, String gender, String email, String address,
			String password, String role,int availableLeave ,long phoneNumber, Date loginTime) {
		super(eid, fname, lname, age, gender, email, address, password, role,availableLeave,phoneNumber, loginTime);
		// TODO Auto-generated constructor stub
	}
	



	public int getTotalLeaveApproved() {
		return totalLeaveApproved;
	}

	public void setTotalLeaveApproved(int totalLeaveApproved) {
		this.totalLeaveApproved = totalLeaveApproved;
	}

	public int getTotalLeaveRejected() {
		return totalLeaveRejected;
	}

	public void setTotalLeaveRejected(int totalLeaveRejected) {
		this.totalLeaveRejected = totalLeaveRejected;
	}


	@Override
	public String toString() {
		return "Manager [totalLeaveApproved=" + totalLeaveApproved + ", totalLeaveRejected=" + totalLeaveRejected
				+ "]";
	}

}