package com.ems.dao;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.entity.Employee;
import com.ems.entity.Leave;

@Repository
public class LeaveDaoImplementation implements LeaveDao {

	@Autowired
	private SessionFactory sessionFactory;

	

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Leave> getLeaveForSpecficEmployee(int eid) {
		Query query = getSession().createQuery("from Leave me where eid=" + eid);
		List<Leave> list =  query.list();
		return list;
	}

	@Override
	public List<Leave> cancelLeave(int leaveId) {
		Query query = getSession().createQuery("delete from Leave em where leaveId=:leaveId");
		query.setParameter("leaveId", leaveId);
		query.executeUpdate();
		

		return getLeave();
	}

	public void createLeave(Leave leave) {
		
	
		leave.setLeaveStatus("Applied");
		leave.setAction("NO");

		getSession().saveOrUpdate(leave);
		
	}

	@Override
	public List<Leave> getLeave() {
		Query getLeaveList = getSession().createQuery(" from Leave me");
		@SuppressWarnings("unchecked")
		List<Leave> leaveList = getLeaveList.list();
		return leaveList;
	}

	@Override
	public List<Leave> approveLeave(Leave leave) {

		int leaveId = leave.getLeaveId();
		String leaveStatus = leave.getLeaveStatus();
	//	String action=leave.getAction();
		Query getAllLeave = getSession().createQuery("from Leave me where leaveId=" + leaveId);
		Leave afterSelectLeaveData = (Leave) getAllLeave.uniqueResult();
		int leaveEid = afterSelectLeaveData.getEid();
		
		Query getEmployee = getSession().createQuery("from Employee me where eid=" + leaveEid);
		Employee employee = (Employee) getEmployee.uniqueResult();

		int employeeId = employee.getEid();

		int availableLeave = employee.getAvailableLeave();
		Date toDate = afterSelectLeaveData.getToDate();
		Date fromDate = afterSelectLeaveData.getFromDate();
		LocalDate fromDay = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate toDay = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Duration difference = Duration.between(fromDay.atStartOfDay(), toDay.atStartOfDay());
		int differenceOfDays = (int) difference.toDays();
		
		String action;
		if (leaveStatus.equals("Approved")) {
			action="YES";
			availableLeave = availableLeave - differenceOfDays;
			Query getLeaveStatus = getSession()
					.createQuery("update Leave  set leaveStatus=:leaveStatus , action=:action  where leaveId=:leaveId");
			Query getAvailableLeave = getSession()
					.createQuery("update Employee  set availableLeave=:availableLeave where eid=:eid");
			getLeaveStatus.setParameter("leaveId", leaveId);
			getLeaveStatus.setParameter("leaveStatus", leaveStatus);
			getLeaveStatus.setParameter("action", action);
			getAvailableLeave.setParameter("eid", employeeId);
			getAvailableLeave.setParameter("availableLeave", availableLeave);
			getLeaveStatus.executeUpdate();
			getAvailableLeave.executeUpdate();
			
			
			
			
		} else {
			action="YES";
			Query getLeaveStatus = getSession()
					.createQuery("update Leave em set leaveStatus=:leaveStatus , action=:action  where leaveId=:leaveId");
			Query getAvailableLeave = getSession()
					.createQuery("update Employee em set availableLeave=:availableLeave where eid=:eid");
			getLeaveStatus.setParameter("leaveId", leaveId);
			getLeaveStatus.setParameter("leaveStatus", leaveStatus);
			getLeaveStatus.setParameter("action", action);
			getAvailableLeave.setParameter("eid", employeeId);
			getAvailableLeave.setParameter("availableLeave", availableLeave);
			getLeaveStatus.executeUpdate();
			getAvailableLeave.executeUpdate();

		}
		return getLeave();

	}


	@Override
	public String getAction(int leaveId) {
		Query query = getSession().createQuery(
				"select le.action from Leave le where leaveId=" + leaveId);
		String action =(String) query.uniqueResult();
		System.out.println("action"+action);
		
		return action;
	}

}
