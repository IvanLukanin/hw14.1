package main.java.com.example.service;

import com.example.collectionandsets1.Employee;
import com.example.exeption.EmployeeAlreadyAddedExeption;
import com.example.exeption.EmployeeNotFoundExeption;
import com.example.exeption.EmployeeStoragesFullExeption;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    private static final int MAX_SIZE = 100;
    private final Map<String, Employee> employees = new HashMap<>(MAX_SIZE);
    public Employee add(String firstName, String lastName){
        if (employees.size() > MAX_SIZE) {
            throw new EmployeeStoragesFullExeption();
        }
        var employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullName())) {
            employees.put(employee.getFullName(), employee);
            return employee;
        } else {
            throw new EmployeeAlreadyAddedExeption();
        }
    }
    public Employee delete(String firstName, String lastName){
        var employee = new Employee(firstName,lastName);
        if (!employees.remove(employee.getFullName  )){
            throw new EmployeeNotFoundExeption();
        }
        return employee;
    }
    public Employee find(String firstName, String lastName){
        var employee = new Employee(firstName,lastName);
        for (Employee emp : employees) {
            if (emp.conteinsKey(employee.getFullName)){
                return employees.get(employee.getFullName);
            }
        }
        throw new EmployeeNotFoundExeption();
    }
}
