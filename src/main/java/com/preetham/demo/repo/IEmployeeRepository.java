package com.preetham.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.preetham.demo.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

}
