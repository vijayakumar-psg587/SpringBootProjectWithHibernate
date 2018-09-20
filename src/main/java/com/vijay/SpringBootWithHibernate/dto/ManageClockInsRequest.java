package com.vijay.SpringBootWithHibernate.dto;

import java.time.LocalDate;

public class ManageClockInsRequest {
	private int mng_Id;
	private int emp_Id;
	private LocalDate date;
	private boolean isAccepted;
	public int getMng_Id() {
		return mng_Id;
	}
	public void setMng_Id(int mng_Id) {
		this.mng_Id = mng_Id;
	}
	public int getEmp_Id() {
		return emp_Id;
	}
	public void setEmp_Id(int emp_Id) {
		this.emp_Id = emp_Id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isAccepted() {
		return isAccepted;
	}
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	
	

}
