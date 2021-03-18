package com.ems.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.entity.Leave;
@Service
@Transactional
public interface ManagerService {

	public List<Leave> totalLeaveApproved(Leave leave);
	public List<Leave> totalLeaveRejected(Leave leave);
	public void setTotalRejectedLeave(int eid);
	public void setTotalApprovedLeave(int eid);
	
	

}
