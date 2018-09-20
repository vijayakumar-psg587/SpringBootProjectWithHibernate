package com.vijay.SpringBootWithHibernate.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.vijay.SpringBootWithHibernate.dto.EmpClockInsResponse;
import com.vijay.SpringBootWithHibernate.dto.EmployeeClockIns;
import com.vijay.SpringBootWithHibernate.service.Emp_ClockInsInterface;


public class Emp_ClockInsServiceImpl implements Emp_ClockInsInterface{
	
	@Autowired
	NamedParameterJdbcTemplate namedTemplate;
	
	@Autowired
	JdbcTemplate simpleJdbcTemplate;
	
	private List<EmployeeClockIns> clockInsList;
	
	public List<EmployeeClockIns> getEmployeeClockIns(){
		String query = "SELECT * FROM emp_clockins";
		clockInsList = simpleJdbcTemplate.query(query, new EmpCheckInsRowMapper());
		return clockInsList;
	}
	
	public static class EmpCheckInsRowMapper implements RowMapper<EmployeeClockIns>{

		@Override
		public EmployeeClockIns mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeClockIns clockIns = new EmployeeClockIns();
			clockIns.setAssigned_manager(rs.getInt("assigned_manager"));
			clockIns.setEmp_id(rs.getInt("emp_id"));
			clockIns.setDate(rs.getDate("date").toLocalDate());
			clockIns.setStart_time(rs.getTimestamp("start_time").toLocalDateTime());
			clockIns.setEnd_time(rs.getTimestamp("end_time").toLocalDateTime());
			return null;
		}
		
	}
	
	@Override
	public EmpClockInsResponse createClockIns(EmployeeClockIns clockIns) {
		// find if the clockIns is already present before creating
		EmpClockInsResponse resp = new EmpClockInsResponse();
		if(!checkIfAlreadyCheckedIn(clockIns)) {
			String query = "INSERT INTO emp_clockins VALUES (:empId, :assg_mng, :dateOfCheckIn, :startTime, :endTime)";
			Map<String, Object> namedParams = new HashMap<>();
			namedParams.put("empId", clockIns.getEmp_id());
			namedParams.put("assg_mng", clockIns.getAssigned_manager());
			namedParams.put("dateOfCheckIn", clockIns.getDate());
			namedParams.put("startTime", clockIns.getStart_time());
			namedParams.put("endTime", clockIns.getEnd_time());
			
			SqlParameterSource source = new MapSqlParameterSource(namedParams);
			
			namedTemplate.update(query, source);
			
			
			//Create new EmpClockIn response
			
			resp.setHttp_status(200);
			resp.setError("");
			resp.setMessage("Successfully created");
		}else {
			resp.setHttp_status(500);
			resp.setError("Error in creating the clockIn");
			resp.setMessage("");
		}
		
		
		return null;
	}
	
	private boolean checkIfAlreadyCheckedIn(EmployeeClockIns clockIns) {
		boolean flag = false;
		for(EmployeeClockIns clockInsTemp: clockInsList) {
			if(clockInsTemp.getAssigned_manager() == clockIns.getAssigned_manager() && clockInsTemp.getEmp_id() ==clockIns.getEmp_id()
					&& clockInsTemp.getDate().equals(clockIns.getDate())) {
				flag = true;
			}
		}
		return flag;
	}
}
