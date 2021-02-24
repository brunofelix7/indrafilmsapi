package com.indracompany.indrafilmsapi.dto;

import java.io.Serializable;

public class ApiErrorDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int statusCode;
	private String message;
	
	public ApiErrorDto() {
		
	}
	
	public ApiErrorDto(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ApiErrorDto [statusCode=" + statusCode + ", message=" + message + "]";
	}
	
}
