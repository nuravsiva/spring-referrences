package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.service.HrService;
    

public class SpringAppInitializer {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		HrService service =(HrService) ctx.getBean("hrService");
		String response = service.registerEmployee(100, "James", "London", 55000);
		System.out.println(":::::::::::"+response);

	}

}
