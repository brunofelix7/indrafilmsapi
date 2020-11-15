package com.indracompany.indrafilmsapi.security;

import java.io.Serializable;

public class ApiResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer statusCode;
	private String message;
	private String token;
	
	public ApiResponse() {
		
	}

	public ApiResponse(Integer statusCode, String message, String token) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.token = token;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "TokenResponse [statusCode=" + statusCode + ", message=" + message + ", token=" + token + "]";
	}

}
