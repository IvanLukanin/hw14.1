package com.example.controller;


import com.example.collectionandsets1.Employee;
import com.example.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,@RequestParam String lastName){
        return service.add(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,@RequestParam String lastName){
        return service.find(firstName, lastName);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,@RequestParam String lastName){
        return service.delete(firstName, lastName);
    }
}
