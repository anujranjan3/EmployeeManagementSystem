package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.ManagerDao;
import com.ems.entity.Leave;

@Service
@Transactional
public class ManagerServiceImplementation implements ManagerService {

	@Autowired
	private ManagerDao managerDao;
	
	@Override
	public List<Leave> totalLeaveApproved(Leave leave) {
		// TODO Auto-generated method stub
		return managerDao.totalLeaveApproved(leave);
	}

	@Override
	public List<Leave> totalLeaveRejected(Leave leave) {
		// TODO Auto-generated method stub
		return managerDao.totalLeaveRejected(leave);
	}

	@Override
	public void setTotalRejectedLeave(int eid) {
		managerDao.setTotalRejectedLeave(eid);
		
	}

	@Override
	public void setTotalApprovedLeave(int eid) {
		managerDao.setTotalApprovedLeave(eid);
		
	}

}