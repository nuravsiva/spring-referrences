package com.demo.spring;

import java.util.Base64;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetClient {

	public static void main(String[] args) {
		
		RestTemplate rt = new RestTemplate();
		/*RequestEntity requestEntity = new RequestEntity(HttpMethod.GET, "http://localhost:8080/greet");*/
		String credentials = "pavan:welcome1";
		String encodedValue = Base64.getEncoder().encodeToString(credentials.getBytes());
		HttpHeaders header =    new HttpHeaders();
		header.add("Accept", "application/JSON");
		header.add("Authorization", "Basic "+ encodedValue);
		HttpEntity env = new HttpEntity(header);
		ResponseEntity<String> response = rt.exchange("http://localhost:8080/emp/101", HttpMethod.GET, env, String.class);
		System.out.println(response.getBody());
		
		
	}

}
