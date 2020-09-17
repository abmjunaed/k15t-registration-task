package com.k15t.pat.server.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().mvcMatchers("/", "/registration", "/api/v1/registration")
				.permitAll();
		http.authorizeRequests().mvcMatchers("/api/v1/registration").permitAll().and().csrf().disable();
	}
}
