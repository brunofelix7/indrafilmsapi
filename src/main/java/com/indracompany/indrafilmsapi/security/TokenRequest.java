package com.indracompany.indrafilmsapi.security;

import java.io.Serializable;

public class TokenRequest implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	
	public TokenRequest() {
		
	}
	
	public TokenRequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AuthDto [email=" + email + ", password=" + password + "]";
	}

}
