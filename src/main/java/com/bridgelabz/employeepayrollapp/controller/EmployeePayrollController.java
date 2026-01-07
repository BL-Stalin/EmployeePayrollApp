package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeePayrollController {

    @GetMapping("/employees")
    public String getEmployees() {
        return "Employee Payroll App is running";
    }
}