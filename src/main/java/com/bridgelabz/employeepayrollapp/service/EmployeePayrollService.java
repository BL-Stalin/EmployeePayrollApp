package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class EmployeePayrollService {

    private List<EmployeePayrollModel> employeeList = new ArrayList<>();
    private int empIdCounter = 1;

    // ==========================
    // USE CASE 1: Add Employee & Get All Employees
    // ==========================
    public EmployeePayrollModel addEmployee(EmployeePayrollDTO employeeDTO) {
        log.debug("Service: Adding employee {}", employeeDTO);
        EmployeePayrollModel employee =
                new EmployeePayrollModel(empIdCounter++, employeeDTO.getName(), employeeDTO.getSalary());
        employeeList.add(employee);
        log.debug("Service: Employee added successfully {}", employee);
        return employee;
    }

    public List<EmployeePayrollModel> getAllEmployees() {
        log.debug("Service: Fetching all employees");
        return employeeList;
    }

    // ==========================
    // USE CASE 3: Get, Update & Delete Employee by ID
    // ==========================
    public EmployeePayrollModel getEmployeeById(int id) {
        log.debug("Service: Fetching employee with id {}", id);
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElseThrow(() -> {
                    log.error("Service: Employee with id {} not found", id);
                    return new EmployeeNotFoundException(
                            "Employee with id " + id + " not found");
                });
    }

    public EmployeePayrollModel updateEmployee(int id, EmployeePayrollDTO employeeDTO) {
        log.debug("Service: Updating employee with id {}", id);
        EmployeePayrollModel employee = getEmployeeById(id);
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        log.debug("Service: Employee updated successfully {}", employee);
        return employee;
    }

    public boolean deleteEmployee(int id) {
        log.debug("Service: Deleting employee with id {}", id);
        EmployeePayrollModel employee = getEmployeeById(id);
        employeeList.remove(employee);
        log.debug("Service: Employee with id {} deleted successfully", id);
        return true;
    }
}
