package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollModel;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeePayrollService {

    private final EmployeePayrollRepository employeePayrollRepository;

    public EmployeePayrollService(EmployeePayrollRepository employeePayrollRepository) {
        this.employeePayrollRepository = employeePayrollRepository;
    }

    // ==========================
    // UC4: Add Employee (DB)
    // ==========================
    public EmployeePayrollModel addEmployee(EmployeePayrollDTO employeeDTO) {
        log.debug("Service: Saving employee to DB {}", employeeDTO);
        EmployeePayrollModel employee = new EmployeePayrollModel(employeeDTO);
        EmployeePayrollModel savedEmployee = employeePayrollRepository.save(employee);
        log.debug("Service: Employee saved successfully {}", savedEmployee);
        return savedEmployee;
    }

    // ==========================
    // UC4: Get All Employees (DB)
    // ==========================
    public List<EmployeePayrollModel> getAllEmployees() {
        log.debug("Service: Fetching all employees from DB");
        return employeePayrollRepository.findAll();
    }

    // ==========================
    // UC4: Get Employee by ID (DB)
    // ==========================
    public EmployeePayrollModel getEmployeeById(int id) {
        log.debug("Service: Fetching employee with id {}", id);
        return employeePayrollRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Service: Employee with id {} not found", id);
                    return new EmployeeNotFoundException(
                            "Employee with id " + id + " not found");
                });
    }

    // ==========================
    // UC4: Update Employee (DB)
    // ==========================
    public EmployeePayrollModel updateEmployee(int id, EmployeePayrollDTO employeeDTO) {
        log.debug("Service: Updating employee with id {}", id);
        EmployeePayrollModel employee = getEmployeeById(id);

        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setGender(employeeDTO.getGender());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setNote(employeeDTO.getNote());
        employee.setProfilePic(employeeDTO.getProfilePic());
        employee.setDepartment(employeeDTO.getDepartment());

        EmployeePayrollModel updatedEmployee = employeePayrollRepository.save(employee);
        log.debug("Service: Employee updated successfully {}", updatedEmployee);
        return updatedEmployee;
    }

    // ==========================
    // UC4: Delete Employee (DB)
    // ==========================
    public void deleteEmployee(int id) {
        log.debug("Service: Deleting employee with id {}", id);
        EmployeePayrollModel employee = getEmployeeById(id);
        employeePayrollRepository.delete(employee);
        log.debug("Service: Employee with id {} deleted successfully", id);
    }
}
