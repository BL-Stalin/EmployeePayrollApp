package com.bridgelabz.employeepayrollapp.model;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "employee_payroll")
public class EmployeePayrollModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    @ElementCollection
    @CollectionTable(
            name = "employee_department",
            joinColumns = @JoinColumn(name = "employee_id")
    )
    @Column(name = "department")
    private List<String> department;

    // constructor used by Service
    public EmployeePayrollModel(EmployeePayrollDTO dto) {
        this.name = dto.getName();
        this.salary = dto.getSalary();
        this.gender = dto.getGender();
        this.startDate = dto.getStartDate();
        this.note = dto.getNote();
        this.profilePic = dto.getProfilePic();
        this.department = dto.getDepartment();
    }
}
