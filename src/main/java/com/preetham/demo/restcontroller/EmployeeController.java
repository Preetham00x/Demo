package com.preetham.demo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Employee addEmployee(@RequestBody Employee emp) {
		return service.addEmployee(emp);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee( @PathVariable Integer id) {
		 service.deleteEmpById(id);
	}
	
	@GetMapping("/{id}")
	public Employee getEmpDetails(@PathVariable Integer id) {
		return service.getEmployeeById(id);
	}
	
	@GetMapping
	public List<Employee> getAllEmpDetails(){
		return service.getAllEmployees();
	}
	
	@PutMapping("/{id}")
	public Employee updateEmpDetails(@RequestBody Employee emp,@PathVariable Integer id) {
		emp.setId(id);
		return service.updateEmployee(emp);
	}
}
