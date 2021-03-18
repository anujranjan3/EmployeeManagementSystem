package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.EmployeeDao;
import com.ems.dao.LeaveDao;
import com.ems.entity.Leave;

@Service
@Transactional
public class LeaveServiceImplementation implements LeaveService{

	@Autowired
	private LeaveDao leaveDao;
	
	@Override
	public List<Leave> getLeaveForSpecficEmployee(int eid) {
		return leaveDao.getLeaveForSpecficEmployee(eid);
	}

	@Override
	public List<Leave> cancelLeave(int leaveId) {
		return leaveDao.cancelLeave(leaveId);
	}

	@Override
	public void createLeave(Leave leave) {
		leaveDao.createLeave(leave);
	}

	@Override
	public List<Leave> getEmployeeLeave() {
		return leaveDao.getLeave();
	}
	
	@Override
	public List<Leave> approveLeave(Leave leave) {
		return leaveDao.approveLeave(leave);
	}

	@Override
	public String getAction(int leaveId) {
		return leaveDao.getAction(leaveId);
	}

}
