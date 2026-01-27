package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.model.EmployeePayrollModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeePayrollRepository
        extends JpaRepository<EmployeePayrollModel, Integer> {

    // ---- UC6: Get employees by department ----
    @Query(value = "SELECT e FROM EmployeePayrollModel e JOIN e.department d WHERE d = :department")
    List<EmployeePayrollModel> findEmployeesByDepartment(@Param("department") String department);
}