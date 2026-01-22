package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class EmployeePayrollDTO {

    @NotEmpty(message = "Employee name cannot be empty")
    @Pattern(
            regexp = "^[A-Z][a-zA-Z\\s]{2,}$",
            message = "Employee name must start with capital letter and have at least 3 characters"
    )
    private String name;

    @Min(value = 1000, message = "Salary must be greater than or equal to 1000")
    private long salary;
}