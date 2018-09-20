package com.vijay.SpringBootWithHibernate.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"emp_id","assigned_manager","date", "start_time", "end_time"})
public class EmployeeClockIns {
	
	private int emp_id;
	private int assigned_manager;
	private LocalDate date;
	private LocalDateTime start_time;
	private LocalDateTime end_time;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public int getAssigned_manager() {
		return assigned_manager;
	}
	public void setAssigned_manager(int assigned_manager) {
		this.assigned_manager = assigned_manager;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDateTime getStart_time() {
		return start_time;
	}
	public void setStart_time(LocalDateTime start_time) {
		this.start_time = start_time;
	}
	public LocalDateTime getEnd_time() {
		return end_time;
	}
	public void setEnd_time(LocalDateTime end_time) {
		this.end_time = end_time;
	}
	
	
	
}
