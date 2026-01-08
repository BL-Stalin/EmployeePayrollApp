package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeePayrollController {

    private List<EmployeePayrollModel> employeeList = new ArrayList<>();
    private int empIdCounter = 1;

    @PostMapping
    public EmployeePayrollModel addEmployee(@RequestBody EmployeePayrollDTO employeeDTO) {
        EmployeePayrollModel employee =
                new EmployeePayrollModel(empIdCounter++, employeeDTO.getName(), employeeDTO.getSalary());
        employeeList.add(employee);
        return employee;
    }

    @GetMapping
    public List<EmployeePayrollModel> getEmployees() {
        return employeeList;
    }
}
