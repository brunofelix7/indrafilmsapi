package com.indracompany.indrafilmsapi.security;

import java.io.Serializable;

public class ApiResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public ApiResponse() {
		
	}

	public ApiResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ApiResponse [message=" + message + "]";
	}

}
