package com.bridgelabz.employeepayrollapp.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeePayrollDTO {

    @NotEmpty(message = "Employee name cannot be empty")
    @Pattern(
            regexp = "^[A-Z][a-zA-Z\\s]{2,}$",
            message = "Name must start with capital letter and have at least 3 characters"
    )
    private String name;

    @Min(value = 1000, message = "Salary must be at least 1000")
    private long salary;

    // ---- Day7 UC2 validations ----

    @NotEmpty(message = "Gender cannot be empty")
    @Pattern(
            regexp = "male|female",
            message = "Gender must be male or female"
    )
    private String gender;

    @NotNull(message = "Start date cannot be null")
    @PastOrPresent(message = "Start date should be past or present date")
    private LocalDate startDate;

    @NotEmpty(message = "Note cannot be empty")
    private String note;

    @NotEmpty(message = "Profile pic cannot be empty")
    private String profilePic;

    @NotNull(message = "Department cannot be null")
    private List<String> department;
}