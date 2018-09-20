package com.vijay.SpringBootWithHibernate.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.vijay.SpringBootWithHibernate.dto.EmployeeClockIns;
import com.vijay.SpringBootWithHibernate.dto.ManageClockInsRequest;
import com.vijay.SpringBootWithHibernate.dto.ManageClockInsResponse;
import com.vijay.SpringBootWithHibernate.service.ManageApprovalsInterface;

public class ManageApprovalsServiceImpl implements ManageApprovalsInterface{
	
	@Autowired
	NamedParameterJdbcTemplate namedTemplate;
	

	
	@Override
	public ManageClockInsResponse manageApprovals(List<ManageClockInsRequest> reqList) {
		// TODO Auto-generated method stub
		ManageClockInsResponse resp = new ManageClockInsResponse();
		String sqlQuery = "Insert INTO manage_approval Values(:mapped_emp, :date, :isacc, :manager_id)";
		List<Map<String, Object>> batchValues = new ArrayList<>(reqList.size());
		Map<String, Object> mapParams = new HashMap<>();
		for(ManageClockInsRequest req: reqList) {
			mapParams.put("mapped_emp", req.getEmp_Id());
			mapParams.put("date", req.getDate());
			mapParams.put("isacc", req.isAccepted());
			mapParams.put("manager_id", req.getMng_Id());
			
			batchValues.add(mapParams);
		}
		try {
			namedTemplate.batchUpdate(sqlQuery, batchValues.toArray(new Map[reqList.size()]));
			
			resp.setMessage("Success");
			resp.setStatus(204);
		}catch(Exception e) {
			resp.setError("Something went wrong");
			resp.setStatus(500);
		}
		
		
		return resp;
	}
	
}
