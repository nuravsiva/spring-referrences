package com.demo.spring.dao;

import com.demo.spring.entity.Emp;

public class EmpDaoJdbcImpl implements EmpDao {

	public String save(Emp e) {
		System.out.println("Emp Data Saved");
		return "sucess";
	}

}
