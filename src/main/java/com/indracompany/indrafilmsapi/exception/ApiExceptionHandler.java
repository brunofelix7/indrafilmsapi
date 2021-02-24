package com.indracompany.indrafilmsapi.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.indracompany.indrafilmsapi.dto.ApiErrorDto;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler  {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiErrorDto> handle500(Exception e, HttpServletRequest request, HttpServletResponse response) {
		if (e instanceof NullPointerException) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
	}

	@ExceptionHandler(RestTemplateException.class)
	public ResponseEntity<ApiErrorDto> handle400(RestTemplateException e, HttpServletRequest request) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage()));
	}

}
