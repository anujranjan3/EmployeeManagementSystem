package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.entity.Employee;
import com.ems.entity.Leave;
@Service
@Transactional
public interface LeaveService {
	
	public List<Leave> getLeaveForSpecficEmployee(int eid);
	public List<Leave> cancelLeave(int leaveId);
	void createLeave(Leave leave);
	List<Leave> getEmployeeLeave();
	List<Leave> approveLeave(Leave leave);
	String getAction(int leaveId);
	

}
