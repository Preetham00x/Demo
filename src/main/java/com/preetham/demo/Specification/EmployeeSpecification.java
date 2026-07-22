package com.preetham.demo.Specification;

import org.springframework.data.jpa.domain.Specification;

import com.preetham.demo.model.Employee;

public class EmployeeSpecification {

    public static Specification<Employee> hasName(String name) {
        return (root, query, cb) ->
                cb.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Employee> hasDeptId(Integer deptId) {
        return (root, query, cb) ->
                cb.equal(root.get("deptId"), deptId);
    }

    public static Specification<Employee> salaryGreaterThan(Double salary) {
        return (root, query, cb) ->
                cb.greaterThan(root.get("salary"), salary);
    }

}