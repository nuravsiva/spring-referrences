package com.demo.spring.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PwdEncrypter {
	
	
	public static void main(String[] args) {
		
		BCryptPasswordEncoder enocoder = new  BCryptPasswordEncoder();
			System.out.println(enocoder.encode("welcome1"));
		}

}
