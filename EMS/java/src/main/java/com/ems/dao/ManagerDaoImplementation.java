package com.ems.dao;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.entity.Leave;
import com.ems.entity.Manager;
@Repository
public class ManagerDaoImplementation implements ManagerDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	
	@Override
	public List<Leave> totalLeaveApproved(Leave leave) {
		Query query = getSession().createQuery("select COUNT(*) from Leave le where leaveStatus='Approved'");
		List<Leave> leaveApprovedList = query.list();
		
		return leaveApprovedList;
	}

	@Override
	public List<Leave> totalLeaveRejected(Leave leave) {
		Query query = getSession().createQuery("select COUNT(*) from Leave le where leaveStatus='Rejected'");
		List<Leave> leaveRejectedList = query.list();
		return leaveRejectedList;
	}


	@Override
	public void setTotalRejectedLeave(int eid) {
		
		Query query=getSession().createQuery("update Manager set  totalLeaveRejected=totalLeaveRejected+1 where eid="+eid);
	query.executeUpdate();
		
		
	}


	@Override
	public void setTotalApprovedLeave(int eid) {

		Query query=getSession().createQuery("update Manager set   totalLeaveApproved=totalLeaveApproved+1 where eid="+eid);
	query.executeUpdate();
	}

}