package com.preetham.demo.service;

import java.util.List;

import com.preetham.demo.dto.EmployeeRequestDto;
import com.preetham.demo.dto.EmployeeResponseDto;
import com.preetham.demo.model.Employee;

import jakarta.validation.Valid;


public interface IEmployeeService {

	EmployeeResponseDto addEmployee(EmployeeRequestDto dto);

	List<EmployeeResponseDto> getAllEmployees();

	EmployeeResponseDto getEmployeeById(Integer id);

	EmployeeResponseDto updateEmployee(Integer id,
	                                   EmployeeRequestDto dto);
	List<EmployeeResponseDto> searchByDeptId(Integer deptId);
	void deleteEmpById(Integer id);
	List<EmployeeResponseDto> searchByEmpName(String name);
	List<EmployeeResponseDto> searchbySalaryGreaterthan(Double salary);
}