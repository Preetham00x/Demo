package com.preetham.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preetham.demo.Mapper.EmployeeMapper;
import com.preetham.demo.dto.EmployeeRequestDto;
import com.preetham.demo.dto.EmployeeResponseDto;
import com.preetham.demo.exception.EmployeeNotFoundException;
import com.preetham.demo.model.Employee;
import com.preetham.demo.repo.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService  {

	
	private IEmployeeRepository repo;
	@Autowired
	private  EmployeeMapper mapper;

	@Autowired
	public EmployeeService(IEmployeeRepository repo) {
	    this.repo = repo;
	    
	}

	@Override
	public EmployeeResponseDto addEmployee(EmployeeRequestDto emp) {
		 Employee employee = mapper.toEntity(emp);

		    Employee savedEmployee = repo.save(employee);
		    return mapper.toDto(savedEmployee);
	}

	@Override
	public List<EmployeeResponseDto> getAllEmployees() {
		List<Employee> employees=repo.findAll();
		// TODO Auto-generated method stub
		return mapper.toDto(employees);
	}

	@Override
	public EmployeeResponseDto getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		 
		Employee employee = repo.findById(id)
		        .orElseThrow(() ->
		                new EmployeeNotFoundException("Employee not found"));

		return mapper.toDto(employee);
	}

	@Override
	public EmployeeResponseDto updateEmployee(Integer id,
	                                          EmployeeRequestDto dto) {

	    Employee employee = repo.findById(id)
	            .orElseThrow(() ->
	                    new EmployeeNotFoundException("Employee not found"));

	    mapper.updateEmployeeFromDto(dto, employee);

	    Employee updated = repo.save(employee);

	    return mapper.toDto(updated);
	}

	@Override
	public void deleteEmpById(Integer id) {
		if(!repo.existsById(id)) {
		throw new RuntimeException("record not present");
		
	}else {
		repo.deleteById(id);}

}}
