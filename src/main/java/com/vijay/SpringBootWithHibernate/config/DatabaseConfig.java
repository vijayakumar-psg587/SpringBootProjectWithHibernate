package com.vijay.SpringBootWithHibernate.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("application.properties")
public class DatabaseConfig {
	
	@Autowired
	Environment env;
	
	@Bean
	public DataSource getDataSource() {
		HikariDataSource ds = new HikariDataSource();
		   ds.setMaximumPoolSize(100);
	        ds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
	        ds.setJdbcUrl(env.getProperty("spring.datasource.url"));;
	        ds.setUsername(env.getProperty("spring.datasource.username"));
	        ds.setPassword(env.getProperty("spring.datasource.password"));
	        ds.addDataSourceProperty("cachePrepStmts", true);
	        ds.addDataSourceProperty("prepStmtCacheSize", 250);
	        ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
	        ds.addDataSourceProperty("useServerPrepStmts", true);
		return ds;
		
	}
	
}
