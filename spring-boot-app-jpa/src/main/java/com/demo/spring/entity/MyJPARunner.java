package com.demo.spring.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.EmpRepository;

@Component
@Transactional
public class MyJPARunner implements CommandLineRunner {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	EmpRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		/*Emp findOne = findOne(1324);
		System.out.println(":::::::::::::Employee Found " + findOne.getName());*/
		/*String saveEmp = saveEmp(new Emp(1111,"Joe", "Las", 256478 ));
		System.out.println(" :::::::::Save Emp response "+ saveEmp);*/
		/*getAll().stream().forEach(emp -> {
			System.out.println("Id "+ emp.getEmpId() + " Name "+ emp.getName());
		});;*/
		
		repo.findAll().stream().forEach(emp -> {
			System.out.println("::::"+emp.getCity() +" emp.getId "+emp.getEmpId());
		});;
		System.out.println("Custom Query");
		/*repo.getNamesWithS().stream().forEach(emp -> {
			System.out.println(" ::::::::::: " + emp.getName());
		});;*/
		
		repo.getNameStartsWith("V").forEach(emp -> {
			System.out.println(emp.getName());
		});
		
		

	}
	
	public Emp findOne(int id) {
		Emp e = em.find(Emp.class, id);
		if( e == null ) {
			throw new RuntimeException("Employee record Not found with Id "+ id);
		}
		return e;
	}
	
	public String saveEmp(Emp e) {
		String response = "";
		try {
			em.persist(e);
			response = "Persistance Success";
		} catch (Exception exc) {
			exc.printStackTrace();
			response = "Failed to Update Employee";
		}
		return response;
	}
	
	public List<Emp> getAll() {
		Query query = em.createQuery("select e from Emp e");
		return query.getResultList();
	}

}
