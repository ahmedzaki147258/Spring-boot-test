package com.hospital.patients.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.patients.model.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
