package com.preetham.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.preetham.demo.exception.EmployeeNotFoundException;
import com.preetham.demo.model.Employee;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String>   exceptionhandler(EmployeeNotFoundException ex) {
		return ex.getMessage();
		
	}

}
