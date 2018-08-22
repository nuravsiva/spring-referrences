package com.demo.spring.dao;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

//@Repository
public class EmpDaoJdbcImpl implements EmpDao {

	public String save(Emp e) {
		System.out.println("Emp Data Saved");
		return "sucess";
	}

}
