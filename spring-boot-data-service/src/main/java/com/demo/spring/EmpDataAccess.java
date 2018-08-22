package com.demo.spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.demo.spring.entity.Emp;

@Component
public class EmpDataAccess {

	@Autowired
	EmpRepository repo;

	public ResponseEntity findById (int id) {
		Optional<Emp> emp = repo.findById(id);
		if(emp.isPresent()) 
			return ResponseEntity.ok(emp.get());
		else 
			throw new RuntimeException("Employee Does Not Exist.....");
	}
	
	@Cacheable("empList")
	public ResponseEntity getEmpList() {
		System.out.println("Retrieving All Employeed....");
		return ResponseEntity.ok(repo.findAll());
	}
	
	public ResponseEntity save(Emp e) {
		if(repo.existsById(e.getEmpId())) {
			return ResponseEntity.ok("Employee Already Exists..");
		}
		else  {
			repo.save(e);
			return ResponseEntity.ok("Employee Saved...!!");
		}
			
	}
	
	public ResponseEntity update(Emp e) {
		if(repo.existsById(e.getEmpId())) {
			repo.save(e);
			return ResponseEntity.ok("Employee Updated...!!");
		}
		else {
			return ResponseEntity.ok("Employee No Found Exists");
		}
	}
	
	
	
	

}
