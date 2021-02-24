package com.indracompany.indrafilmsapi.exception;

public class RestTemplateException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public RestTemplateException(String msg) {
		super(msg);
	}
	
	public RestTemplateException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
