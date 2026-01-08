package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService {

    private List<EmployeePayrollModel> employeeList = new ArrayList<>();
    private int empIdCounter = 1;

    // ==========================
    // USE CASE 1: Add Employee & Get All Employees
    // ==========================
    public EmployeePayrollModel addEmployee(EmployeePayrollDTO employeeDTO) {
        EmployeePayrollModel employee =
                new EmployeePayrollModel(empIdCounter++, employeeDTO.getName(), employeeDTO.getSalary());
        employeeList.add(employee);
        return employee;
    }

    public List<EmployeePayrollModel> getAllEmployees() {
        return employeeList;
    }

    // ==========================
    // USE CASE 3: Get, Update & Delete Employee by ID
    // ==========================
    public EmployeePayrollModel getEmployeeById(int id) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public EmployeePayrollModel updateEmployee(int id, EmployeePayrollDTO employeeDTO) {
        EmployeePayrollModel employee = getEmployeeById(id);
        if (employee != null) {
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
        }
        return employee;
    }

    public boolean deleteEmployee(int id) {
        return employeeList.removeIf(emp -> emp.getId() == id);
    }
}
