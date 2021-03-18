package com.ems.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ems.entity.Leave;
@Repository
public interface ManagerDao {

	public List<Leave> totalLeaveApproved(Leave leave);
	public List<Leave> totalLeaveRejected(Leave leave);
	public void setTotalRejectedLeave(int eid);
	public void setTotalApprovedLeave(int eid);

}
