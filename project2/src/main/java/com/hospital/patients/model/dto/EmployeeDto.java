package com.hospital.patients.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hospital.patients.model.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Integer id;
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Double salary;

    public static EmployeeDto toDto(Employee emp) {
        return EmployeeDto.builder()
                .id(emp.getId())
                .name(emp.getName())
                // .salary(emp.getSalary())
                .build();
    }
}
