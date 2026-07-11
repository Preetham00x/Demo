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

import com.preetham.demo.dto.EmployeeRequestDto;
import com.preetham.demo.dto.EmployeeResponseDto;
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
		public ResponseEntity<EmployeeResponseDto> addEmployee(@Valid @RequestBody EmployeeRequestDto emp) {
			EmployeeResponseDto saved=service.addEmployee(emp);
			 return new ResponseEntity<EmployeeResponseDto>(saved,HttpStatus.CREATED);
			 
			
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deleteEmployee( @Valid @PathVariable Integer id) {
			 service.deleteEmpById(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<EmployeeResponseDto> getEmpDetails(@Valid @PathVariable Integer id) {
			EmployeeResponseDto e= service.getEmployeeById(id);
			return new ResponseEntity<>(e,HttpStatus.OK);
		}
		
		@GetMapping
		public ResponseEntity<List<EmployeeResponseDto>> getAllEmpDetails(){
			List<EmployeeResponseDto> e=service.getAllEmployees();
			return new ResponseEntity<>(e,HttpStatus.OK);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<EmployeeResponseDto> updateEmpDetails(
		        @PathVariable Integer id,
		        @Valid @RequestBody EmployeeRequestDto dto) {

		    return ResponseEntity.ok(service.updateEmployee(id, dto));
		}
	}
