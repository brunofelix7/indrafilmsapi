package com.indracompany.indrafilmsapi.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import com.indracompany.indrafilmsapi.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.indracompany.indrafilmsapi.service.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService service;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = service.findByEmail(email);
		
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}
	
}
