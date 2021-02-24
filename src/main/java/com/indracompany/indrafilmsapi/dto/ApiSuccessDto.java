package com.indracompany.indrafilmsapi.dto;

import java.io.Serializable;

public class ApiSuccessDto<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private int statusCode;
	private String message;	
	private T body;
	
	public ApiSuccessDto() {
		
	}

	public ApiSuccessDto(int statusCode, String message, T body) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.body = body;
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

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "ApiSuccessDto [statusCode=" + statusCode + ", message=" + message + ", body=" + body + "]";
	}
	
}
