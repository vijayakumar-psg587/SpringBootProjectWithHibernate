package com.vijay.SpringBootWithHibernate.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"message", "error", "http_status"})
public class EmpClockInsResponse {

	private String message;
	private String error;
	private int http_status;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getHttp_status() {
		return http_status;
	}
	public void setHttp_status(int http_status) {
		this.http_status = http_status;
	}
	
	
}
