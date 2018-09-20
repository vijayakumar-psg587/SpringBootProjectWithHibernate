package com.vijay.SpringBootWithHibernate.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcImplementation {
	
	@Autowired
	DataSource datasource;
	
	@Bean
	public JdbcTemplate simpleJdbcTemple() {
		return new JdbcTemplate(datasource);
	}
	
	@Bean
	public NamedParameterJdbcTemplate namedTemplate() {
		return new NamedParameterJdbcTemplate(datasource);
	}
}
