package com.ems.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ems.entity.Employee;
import com.ems.entity.Leave;
@Repository
public interface LeaveDao {
	
	List<Leave> getLeaveForSpecficEmployee(int eid);
	List<Leave> cancelLeave(int leaveId);
	void createLeave(Leave leave);
	List<Leave> getLeave();
	List<Leave> approveLeave(Leave leave);
	String getAction(int leaveId);
	
}
