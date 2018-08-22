package com.demo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.EmpDataAccess;
import com.demo.spring.entity.Emp;

@RestController
public class EmpRestController {

	@Autowired
	EmpDataAccess dao;

	@RequestMapping(path = "/greet", method = RequestMethod.GET)
	public String getMsg() {
		return "Hello from Spring REST";

	}

	@RequestMapping(path = "/emp/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity retrieveById(@PathVariable("id") int id) {
		return ResponseEntity.ok(dao.findById(id));
	}

	@RequestMapping(path = "/emp", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity listAll() {
		return ResponseEntity.ok(dao.getEmpList());
	}
	@RequestMapping(path="/emp/save",
			method=RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity save(@RequestBody Emp e) {
		return dao.save(e);
	} 
	@RequestMapping(path="/emp/update",
			method=RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity update(@RequestBody Emp e) {
		return dao.update(e);
	}

}
