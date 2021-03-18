package com.ems.entity;

import java.util.Date;

import javax.persistence.CascadeType;

//import java.sql.Date;

//import java.util.Date;
//import java.time.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "LEAVE")

public class Leave {

	@Id
	@GeneratedValue
	private int leaveId;
	private String leaveType;
	private String leaveStatus;
	private String leaveComment;
	private Date toDate;
	private Date fromDate;
	private String action;

	
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinTable(name="Employee",joinColumns=@JoinColumn(name = "eid", referencedColumnName = "eid"))
	private int eid;
	

	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Leave(int leaveId, String leaveType, String leaveStatus, String leaveComment, Date toDate, Date fromDate,
			String action, int eid) {
		super();
		this.leaveId = leaveId;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.leaveComment = leaveComment;
		this.toDate = toDate;
		this.fromDate = fromDate;
		this.action = action;
	
	}
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	public String getLeaveComment() {
		return leaveComment;
	}
	public void setLeaveComment(String leaveComment) {
		this.leaveComment = leaveComment;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	@Override
	public String toString() {
		return "Leave [leaveId=" + leaveId + ", leaveType=" + leaveType + ", leaveStatus=" + leaveStatus
				+ ", leaveComment=" + leaveComment + ", toDate=" + toDate + ", fromDate=" + fromDate + ", action="
				+ action + ", eid=" + eid + "]";
	}

	
	}