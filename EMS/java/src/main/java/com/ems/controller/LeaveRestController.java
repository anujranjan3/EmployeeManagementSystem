package com.ems.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.Leave;

import com.ems.service.LeaveService;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
public class LeaveRestController {

	@Autowired
	LeaveService leaveService;
	Leave leave;

	@GetMapping("/searchLeave/{eid}")
	public ResponseEntity<List<Leave>> getLeaveForSpecficEmployee(@PathVariable("eid") int eid) {
	
		
		List<Leave>list= leaveService.getLeaveForSpecficEmployee(eid);
		
		if (list.isEmpty()) {
			return new ResponseEntity<List<Leave>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Leave>>(list, HttpStatus.OK);
		
		
	}

	@DeleteMapping("/cancelLeave/{leaveId}")
	private ResponseEntity<List<Leave>> cancelLeave(@PathVariable("leaveId") int leaveId) {

		List<Leave> list = leaveService.cancelLeave(leaveId);
		if (list.isEmpty()) {
			return new ResponseEntity<List<Leave>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Leave>>(list, HttpStatus.OK);
	}

	@PostMapping("/applyLeave")
	public Leave createLeave(@RequestBody Leave leave) {
		leaveService.createLeave(leave);
		return leave;
	}

	@GetMapping("/getLeave")
	private ResponseEntity<List<Leave>> aleave() {

		List<Leave> li = leaveService.getEmployeeLeave();
		if (li.isEmpty()) {
			return new ResponseEntity<List<Leave>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Leave>>(li, HttpStatus.OK);
	}

	@PutMapping("/approveLeave/{leaveId}")
	private ResponseEntity<List<Leave>> approveLeave(@PathVariable("leaveId") int leaveId) {
		Leave leave1 = new Leave();
		leave1.setLeaveId(leaveId);
		leave1.setLeaveStatus("Approved");
		List<Leave> list = leaveService.approveLeave(leave1);
		if (list.isEmpty()) {
			return new ResponseEntity<List<Leave>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Leave>>(list, HttpStatus.OK);
	}
	@PutMapping("/rejectLeave/{leaveId}")
	private ResponseEntity<List<Leave>> rejectLeave(@PathVariable("leaveId") int leaveId) {
		Leave leave1 = new Leave();
		leave1.setLeaveId(leaveId);
		leave1.setLeaveStatus("Rejected");
		List<Leave> list = leaveService.approveLeave(leave1);
		if (list.isEmpty()) {
			return new ResponseEntity<List<Leave>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Leave>>(list, HttpStatus.OK);
	}

	@GetMapping("/action/{leaveId}")
	public ResponseEntity<List<String>> getAction(@PathVariable("leaveId") int leaveId) {
	
		List<String> list=new ArrayList<String>();
		
		String action= leaveService.getAction(leaveId);
		list.add(action);
	
		return new ResponseEntity <List<String>>(list, HttpStatus.OK);
		
		
	}
}
