package com.vijay.SpringBootWithHibernate.service;

import com.vijay.SpringBootWithHibernate.dto.EmpClockInsResponse;
import com.vijay.SpringBootWithHibernate.dto.EmployeeClockIns;

public interface Emp_ClockInsInterface {
	
	public EmpClockInsResponse createClockIns(EmployeeClockIns clockIns);
}
