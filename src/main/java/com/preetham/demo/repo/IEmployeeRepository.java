package com.preetham.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.preetham.demo.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>,JpaSpecificationExecutor<Employee> {
	List<Employee> findByName(String name);
	List<Employee> findByDeptId(Integer deptId);
	List<Employee> findBySalaryGreaterThan(Double Salary);

}
