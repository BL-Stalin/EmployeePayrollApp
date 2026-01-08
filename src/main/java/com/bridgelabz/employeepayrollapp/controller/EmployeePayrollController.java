package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollModel;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    @PostMapping
    public EmployeePayrollModel addEmployee(@RequestBody EmployeePayrollDTO employeeDTO) {
        return employeePayrollService.addEmployee(employeeDTO);
    }

    @GetMapping
    public List<EmployeePayrollModel> getEmployees() {
        return employeePayrollService.getAllEmployees();
    }
}
