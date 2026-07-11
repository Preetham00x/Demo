package com.preetham.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.preetham.demo.model.Employee;
import com.preetham.demo.service.IEmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private IEmployeeService service;

	@Autowired
	public EmployeeController(IEmployeeService service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee emp) {
		Employee saved=service.addEmployee(emp);
		 return new ResponseEntity<>(saved,HttpStatus.CREATED);
		 
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee( @PathVariable Integer id) {
		 service.deleteEmpById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmpDetails(@PathVariable Integer id) {
		Employee e= service.getEmployeeById(id);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmpDetails(){
		List<Employee> e=service.getAllEmployees();
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmpDetails(@Valid @RequestBody Employee emp,@PathVariable Integer id) {
		emp.setId(id);
		Employee e=service.updateEmployee(emp);
		return new ResponseEntity<>(e,HttpStatus.OK);
	}
}
