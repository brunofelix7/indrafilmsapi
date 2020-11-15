package com.indracompany.indrafilmsapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests().antMatchers("/api/auth").permitAll()
		.and()
		.authorizeRequests().antMatchers("/api/movies").authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		http.httpBasic().authenticationEntryPoint(restAuthenticationEntryPoint);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
}
