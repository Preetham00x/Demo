package com.preetham.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.preetham.demo.model.Employee;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String>   exceptionhandler(EmployeeNotFoundException ex) {
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
		
	}

}
