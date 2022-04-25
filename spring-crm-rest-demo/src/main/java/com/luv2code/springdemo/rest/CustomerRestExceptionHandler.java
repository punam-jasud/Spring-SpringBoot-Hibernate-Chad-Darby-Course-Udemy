package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(CustomerNotFoundException ex){
		
		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		customErrorResponse.setMessage(ex.getMessage());
		customErrorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<CustomErrorResponse>(customErrorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomErrorResponse> handleException(Exception ex){
		
		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		customErrorResponse.setMessage(ex.getMessage());
		customErrorResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<CustomErrorResponse>(customErrorResponse,HttpStatus.BAD_REQUEST);
	}

}
