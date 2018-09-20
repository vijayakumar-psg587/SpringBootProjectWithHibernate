package com.vijay.SpringBootWithHibernate.service;

import java.util.List;

import com.vijay.SpringBootWithHibernate.dto.ManageClockInsRequest;
import com.vijay.SpringBootWithHibernate.dto.ManageClockInsResponse;

public interface ManageApprovalsInterface {
	
	public ManageClockInsResponse manageApprovals(List<ManageClockInsRequest> reqList);
}
