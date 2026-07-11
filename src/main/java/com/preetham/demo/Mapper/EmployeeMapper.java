package com.preetham.demo.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import com.preetham.demo.dto.EmployeeRequestDto;
import com.preetham.demo.dto.EmployeeResponseDto;
import com.preetham.demo.model.Employee;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    Employee toEntity(EmployeeRequestDto dto);

    EmployeeResponseDto toDto(Employee employee);

    List<EmployeeResponseDto> toDto(List<Employee> employees);

    void updateEmployeeFromDto(
            EmployeeRequestDto dto,
            @MappingTarget Employee employee
    );
}
