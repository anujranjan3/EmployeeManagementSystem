package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.Leave;

import com.ems.service.ManagerService;
import com.sun.net.httpserver.Authenticator.Success;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class ManagerRestController {

	@Autowired
	ManagerService managerService;
	Leave leave;
	

	@GetMapping("/getApprovedLeaves")
	private ResponseEntity<List<Leave>> approvedLeave() {

		List<Leave> li = managerService.totalLeaveApproved(leave);
		if (li.isEmpty()) {
			return new ResponseEntity<List<Leave>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Leave>>(li, HttpStatus.OK);
	}

	@GetMapping("/getRejectedLeaves")
	private ResponseEntity<List<Leave>> rejectedLeave() {

		List<Leave> li = managerService.totalLeaveRejected(leave);
		if (li.isEmpty()) {
			return new ResponseEntity<List<Leave>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Leave>>(li, HttpStatus.OK);
	}
	
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/totalRejectedLeave/{eid}")
	private ResponseEntity  setTotalRejectedLeave(@PathVariable("eid") int eid) {
		managerService.setTotalRejectedLeave(eid);
		

		return new ResponseEntity ( HttpStatus.OK);
	}
	

	@SuppressWarnings("rawtypes")
	@GetMapping("/totalApprovedLeave/{eid}")
	private ResponseEntity  setTotalApprovedLeave(@PathVariable("eid") int eid) {
		managerService.setTotalApprovedLeave(eid);

		return new ResponseEntity ( HttpStatus.OK);
	}
	
	

}
