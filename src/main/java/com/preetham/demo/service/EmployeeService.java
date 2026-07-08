package com.preetham.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preetham.demo.model.Employee;
import com.preetham.demo.repo.IEmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService  {

	
	private IEmployeeRepository repo;
	
	@Autowired
	public void setRepo(IEmployeeRepository repo) {
		this.repo = repo;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		return repo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		 
		 return repo.findById(id).orElseThrow(()-> new RuntimeException("emp not found"));
	}

	@Override
	public Employee updateEmployee(Employee emp) {

		Optional<Employee> optional= repo.findById(emp.getId());
		if(optional.isPresent()) {
			return repo.save(emp);
		}else {
			throw new RuntimeException("emp record not found");
		}
		
		
		
	}

	@Override
	public void deleteEmpById(Integer id) {
		if(!repo.existsById(id)) {
		throw new RuntimeException("record not present");
		
	}else {
		repo.deleteById(id);}

}}
