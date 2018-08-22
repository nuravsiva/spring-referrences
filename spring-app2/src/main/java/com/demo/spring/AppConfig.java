package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.spring.dao.EmpDaoJdbcImpl;

@Configuration
@ComponentScan(basePackages="com.demo.spring")
public class AppConfig {
	//Loading Component at Config level.
	@Bean
	public EmpDaoJdbcImpl mydao() {
		return new EmpDaoJdbcImpl();
	}

}
