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

    public EmployeePayrollModel addEmployee(EmployeePayrollDTO employeeDTO) {
        EmployeePayrollModel employee =
                new EmployeePayrollModel(empIdCounter++, employeeDTO.getName(), employeeDTO.getSalary());
        employeeList.add(employee);
        return employee;
    }

    public List<EmployeePayrollModel> getAllEmployees() {
        return employeeList;
    }
}
