package com.microservice.employeeservice.service;

import com.microservice.employeeservice.entity.Employee;
import com.microservice.employeeservice.entity.ResponseTemplate;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    ResponseTemplate getEmployeeWithDepartment(Long employeeId);

    List<Employee> findAll();
}
