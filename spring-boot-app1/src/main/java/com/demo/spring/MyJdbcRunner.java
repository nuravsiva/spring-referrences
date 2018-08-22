package com.demo.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;

@Component
public class MyJdbcRunner implements CommandLineRunner {

	@Autowired
	JdbcTemplate jt;

	@Override
	public void run(String... args) throws Exception {
		String insterQuery = "insert into EMP(empno, name,address,salary) values(?,?,?,?)";
		jt.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pst = con.prepareStatement(insterQuery);
					pst.setInt(1, 1324);
					pst.setString(2, "Varun");
					pst.setString(3, "Chennai"); 
					pst.setDouble(4, 65000);
					return pst;
			}
		});

	}

}
