package com.preetham.demo.service;

import java.util.List;
import java.util.Optional;

import com.preetham.demo.model.Employee;

public interface IEmployeeService {
	
	
	Employee addEmployee(Employee emp);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Integer id);
	Employee updateEmployee(Employee emp);
	void deleteEmpById(Integer id);
	

}
