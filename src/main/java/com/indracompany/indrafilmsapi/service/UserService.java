package com.indracompany.indrafilmsapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indracompany.indrafilmsapi.domain.User;
import com.indracompany.indrafilmsapi.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User findByEmail(String email) {
		return repository.findByEmail(email).orElse(null);
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
}
