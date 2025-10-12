package com.hospital.patients.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.patients.model.dto.EmployeeDto;
import com.hospital.patients.model.entity.Employee;
import com.hospital.patients.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(EmployeeDto::toDto).toList();
    }

    public EmployeeDto getEmployee(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return EmployeeDto.toDto(employee.orElse(null));
    }

    public EmployeeDto saveEmployee(EmployeeDto empDto) {
        return EmployeeDto.toDto(employeeRepository.save(Employee.toEntity(empDto)));
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
