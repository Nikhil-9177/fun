package com.example.employee_Portal.controller;

import com.example.employee_Portal.model.Employee;
import com.example.employee_Portal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:3000") // Allow React app to call API
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    // GET: Retrieve all employees
    @GetMapping
    public List<Employee> getEmployees() {
        return service.getAllEmployees();
    }

    // GET: Retrieve employee by ID 
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    // POST: Create a new employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    // PUT: Update an existing employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        return service.updateEmployee(id, employeeDetails);
    }

    // DELETE: Delete an employee by ID
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee with ID " + id + " deleted successfully.";
    }
}

