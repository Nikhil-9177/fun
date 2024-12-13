package com.example.employee_Portal.repository;


import com.example.employee_Portal.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
