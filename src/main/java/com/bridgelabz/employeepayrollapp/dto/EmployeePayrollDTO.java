package com.bridgelabz.employeepayrollapp.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EmployeePayrollDTO {

    private String name;
    private long salary;

    // ---- Day7 UC1 fields ----
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> department;
}
