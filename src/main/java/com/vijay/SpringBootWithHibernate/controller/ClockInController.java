package com.vijay.SpringBootWithHibernate.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.SpringBootWithHibernate.dto.EmpClockInsResponse;
import com.vijay.SpringBootWithHibernate.dto.EmployeeClockIns;
import com.vijay.SpringBootWithHibernate.dto.ManageClockInsRequest;
import com.vijay.SpringBootWithHibernate.dto.ManageClockInsResponse;
import com.vijay.SpringBootWithHibernate.service.impl.Emp_ClockInsServiceImpl;
import com.vijay.SpringBootWithHibernate.service.impl.ManageApprovalsServiceImpl;

@RestController
@RequestMapping(path="/v1")
public class ClockInController {
	
	@RequestMapping(path="/clockIns", method=RequestMethod.POST, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<EmpClockInsResponse> clockInWork(@PathVariable("emp_Id") Integer empId, EmployeeClockIns clockIns ){
		Emp_ClockInsServiceImpl serviceImpl = new Emp_ClockInsServiceImpl();
		EmpClockInsResponse res = serviceImpl.createClockIns(clockIns);
		return new ResponseEntity<EmpClockInsResponse>(res, HttpStatus.OK);
	}
	

	@RequestMapping(path="/getAllClockIns", method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	
	public ResponseEntity<List<EmployeeClockIns>> getAllEmployeeClockIns(){
		Emp_ClockInsServiceImpl empServiceImpl = new Emp_ClockInsServiceImpl();
		List<EmployeeClockIns> empClockInsList = empServiceImpl.getEmployeeClockIns();
		return new ResponseEntity<List<EmployeeClockIns>>(empClockInsList, HttpStatus.OK);
	}
	
	@RequestMapping(path="/manageClockIns", method=RequestMethod.POST, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
	, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}) 
	public ResponseEntity<ManageClockInsResponse> acceptRejectEmployeeInput(List<ManageClockInsRequest> reqList){
		ManageApprovalsServiceImpl serviceImpl = new ManageApprovalsServiceImpl();
		ManageClockInsResponse resp = serviceImpl.manageApprovals(reqList);
		return new ResponseEntity<ManageClockInsResponse>(resp, HttpStatus.OK);
	}

}
