package com.bridgelabz.employeepayrollapp.dto;

public class EmployeePayrollDTO {

    private String name;
    private long salary;

    public EmployeePayrollDTO() {}

    public EmployeePayrollDTO(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }
}
