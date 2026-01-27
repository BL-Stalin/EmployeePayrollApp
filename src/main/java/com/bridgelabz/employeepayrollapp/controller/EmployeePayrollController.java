package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollModel;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employees")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;
    //-- Day-7 -- COMPLETE-CRUD --//
    // ---- UC1-POST ----
    @PostMapping
    public EmployeePayrollModel addEmployee(
            @Valid @RequestBody EmployeePayrollDTO employeeDTO) {
        log.info("Adding employee with name: {}", employeeDTO.getName());
        return employeePayrollService.addEmployee(employeeDTO);
    }

    // ---- UC2-GET-ALL ----
    @GetMapping
    public List<EmployeePayrollModel> getAllEmployees() {
        log.info("Fetching all employees");
        return employeePayrollService.getAllEmployees();
    }

    // ---- UC3-GET-BY-ID ----
    @GetMapping("/{id}")
    public EmployeePayrollModel getEmployeeById(@PathVariable int id) {
        log.info("Fetching employee with id: {}", id);
        return employeePayrollService.getEmployeeById(id);
    }

    // ---- UC4-PUT ----
    @PutMapping("/{id}")
    public EmployeePayrollModel updateEmployee(
            @PathVariable int id,
            @Valid @RequestBody EmployeePayrollDTO employeeDTO) {
        log.info("Updating employee with id: {}", id);
        return employeePayrollService.updateEmployee(id, employeeDTO);
    }

    // ---- UC5-DELETE ----
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        log.info("Deleting employee with id: {}", id);
        employeePayrollService.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}
