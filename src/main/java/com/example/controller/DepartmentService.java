package com.example.controller;

import com.example.collectionandsets1.Employee;
import com.example.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee max (int dept) {
        return employeeService.getEmployess()
                .stream()
                .filter(e -- e.getDepartment() == dept)
                .max (Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }
}
