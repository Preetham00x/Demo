package com.preetham.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class EmployeeResponseDto {
	private Integer id;
	
	private String name;
	
	private Double salary;
	
	private String deptName;
	
	private Integer deptId;

}
