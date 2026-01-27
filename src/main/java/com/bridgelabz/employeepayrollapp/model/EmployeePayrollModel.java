package com.bridgelabz.employeepayrollapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class EmployeePayrollModel {

    private int id;
    private String name;
    private long salary;

    // ---- Day7 UC1 fields ----
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
    private List<String> department;

    public EmployeePayrollModel(int id, String name, long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
