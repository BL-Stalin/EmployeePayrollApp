package com.bridgelabz.employeepayrollapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeePayrollModel {
    private int id;
    private String name;
    private long salary;
}