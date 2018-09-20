package com.vijay.SpringBootWithHibernate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value= {"id", "name", "age", "ismanager"})
public class EmployeeClass {
	
	@JsonProperty("id")
	private Integer Id;
	
	
	private String name;
	private Integer age;
	private boolean ismanager;
	
	
	public boolean isIsmanager() {
		return ismanager;
	}
	public void setIsmanager(boolean ismanager) {
		this.ismanager = ismanager;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
