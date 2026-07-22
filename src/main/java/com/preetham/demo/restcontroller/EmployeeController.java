	package com.preetham.demo.restcontroller;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		@GetMapping("/search/name")
		public ResponseEntity<List<EmployeeResponseDto>> searchByEmpName(@RequestParam String name){
			List<EmployeeResponseDto> emp=service.searchByEmpName(name);
			return ResponseEntity.ok(emp);
			
		}
		@GetMapping("/search/deptId")
		public ResponseEntity<List<EmployeeResponseDto>> searchBydeptId(@RequestParam Integer deptId){
			List<EmployeeResponseDto> emp=service.searchByDeptId(deptId);
			return new ResponseEntity<>(emp,HttpStatus.OK);
			
		}
		@GetMapping("/page")
		public ResponseEntity<Page<EmployeeResponseDto>> getEmployeesPage(
		        @RequestParam(defaultValue="0") int page,
		        @RequestParam(defaultValue="5") int size){

		    return ResponseEntity.ok(
		        service.getEmployeesWithPagination(page,size)
		    );
		}
		@GetMapping("/sort")
		public ResponseEntity<List<EmployeeResponseDto>> getSortedEmployees(
		        @RequestParam String field,
		        @RequestParam(defaultValue = "asc") String direction){

		    return ResponseEntity.ok(
		            service.getEmployeesSorted(field, direction)
		    );
		}
		
		@GetMapping("/search/salary")
		public ResponseEntity<List<EmployeeResponseDto>> searchBySalary(@RequestParam Double salary){
			List<EmployeeResponseDto> e=service.searchbySalaryGreaterthan(salary);
			return new ResponseEntity<>(e,HttpStatus.OK);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<EmployeeResponseDto> updateEmpDetails(
		        @PathVariable Integer id,
		        @Valid @RequestBody EmployeeRequestDto dto) {

		    return ResponseEntity.ok(service.updateEmployee(id, dto));
		}
	}
