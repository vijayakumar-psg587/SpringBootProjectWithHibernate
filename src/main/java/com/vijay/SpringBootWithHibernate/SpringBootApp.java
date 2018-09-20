package com.vijay.SpringBootWithHibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan(basePackages= {"com.vijay.SpringBootWithHibernate.*"})
public class SpringBootApp 
{
    public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootApp.class, args);
	}

}
