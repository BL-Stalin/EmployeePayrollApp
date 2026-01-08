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

    // ==========================
    // USE CASE 1: Add Employee
    // ==========================
    @PostMapping
    public EmployeePayrollModel addEmployee(@RequestBody EmployeePayrollDTO employeeDTO) {
        return employeePayrollService.addEmployee(employeeDTO);
    }

    // ==========================
    // USE CASE 1: Get All Employees
    // ==========================
    @GetMapping
    public List<EmployeePayrollModel> getAllEmployees() {
        return employeePayrollService.getAllEmployees();
    }

    // ==========================
    // USE CASE 3: Get Employee by ID
    // ==========================
    @GetMapping("/{id}")
    public EmployeePayrollModel getEmployeeById(@PathVariable int id) {
        return employeePayrollService.getEmployeeById(id);
    }

    // ==========================
    // USE CASE 3: Update Employee
    // ==========================
    @PutMapping("/{id}")
    public EmployeePayrollModel updateEmployee(
            @PathVariable int id,
            @RequestBody EmployeePayrollDTO employeeDTO) {
        return employeePayrollService.updateEmployee(id, employeeDTO);
    }

    // ==========================
    // USE CASE 3: Delete Employee
    // ==========================
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        boolean deleted = employeePayrollService.deleteEmployee(id);
        return deleted
                ? "Employee deleted successfully"
                : "Employee not found";
    }
}
