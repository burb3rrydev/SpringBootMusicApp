package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gcu.business.UserBusinessService;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{

	@Autowired
	UserBusinessService service;

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.httpBasic().and()
		.authorizeHttpRequests((requests) -> requests
			.requestMatchers("/", "/images/**", "/register/**").permitAll()
			.anyRequest().authenticated()
		)
		.formLogin((form) -> form
			.loginPage("/login")
			.defaultSuccessUrl("/main", true)
			.permitAll()
		)
		.logout((logout) -> logout.permitAll());

	return http.build();
}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		auth
		.userDetailsService(service)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
}