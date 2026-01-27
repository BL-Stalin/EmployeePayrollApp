package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository
        extends JpaRepository<EmployeePayrollModel, Integer> {
}
