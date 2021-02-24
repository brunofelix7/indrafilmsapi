package com.indracompany.indrafilmsapi.exception;

public class AuthenticationFailException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public AuthenticationFailException(String msg) {
		super(msg);
	}

	public AuthenticationFailException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
