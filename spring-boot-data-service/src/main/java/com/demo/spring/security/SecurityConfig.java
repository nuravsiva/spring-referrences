package com.demo.spring.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource ds;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/emp/**").
		hasAnyRole("USER", "ADMIN") // These roles will be blocked.
		.and()
		.httpBasic()
		.and().
		csrf().disable();
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication().withUser("pavan").password(passwordEncoder().encode("password")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("password").password(passwordEncoder().encode("password")).roles("ADMIN");
		// will it block access?
		auth.inMemoryAuthentication().withUser("pavan").password(passwordEncoder().encode("password")).roles("ADMIN").disabled(true);*/
		auth.jdbcAuthentication().
		dataSource(ds).
		usersByUsernameQuery("select username, password, enabled from users where username=?").
		authoritiesByUsernameQuery("select username, authority from authorities where username=?");
		
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}

}
