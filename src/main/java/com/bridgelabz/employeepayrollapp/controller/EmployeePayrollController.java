package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollModel;
import com.bridgelabz.employeepayrollapp.service.EmployeePayrollService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employees")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService employeePayrollService;

    // ---- UC1-POST ----
    @PostMapping
    public EmployeePayrollModel addEmployee(@RequestBody EmployeePayrollDTO employeeDTO) {
        log.info("Adding employee with name: {}", employeeDTO.getName());
        return employeePayrollService.addEmployee(employeeDTO);
    }

    // ---- UC1-GET-ALL ----
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

    // ---- UC3-PUT ----
    @PutMapping("/{id}")
    public EmployeePayrollModel updateEmployee(
            @PathVariable int id,
            @RequestBody EmployeePayrollDTO employeeDTO) {
        log.info("Updating employee with id: {}", id);
        return employeePayrollService.updateEmployee(id, employeeDTO);
    }

    // ---- UC3-DELETE ----
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        log.info("Deleting employee with id: {}", id);
        boolean deleted = employeePayrollService.deleteEmployee(id);
        return deleted
                ? "Employee deleted successfully"
                : "Employee not found";
    }
}
