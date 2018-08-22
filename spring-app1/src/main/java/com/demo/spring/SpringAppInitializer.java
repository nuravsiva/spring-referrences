package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.spring.service.HrService;

public class SpringAppInitializer {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		
		HrService service =(HrService) ctx.getBean("hrService");
		String response = service.registerEmployee(100, "James", "London", 55000);
		System.out.println(":::::::::::"+response);

	}

}
