package com.microservice.employeeservice.controller;

import com.microservice.employeeservice.entity.Employee;
import com.microservice.employeeservice.entity.ResponseTemplate;
import com.microservice.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/health")
    public String getHealth(){
        return "Employee service is up and running";
    }

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public ResponseTemplate getEmployeeWithDepartment(@PathVariable("id") Long employeeId) {
        return employeeService.getEmployeeWithDepartment(employeeId);
    }

    @GetMapping("/get-all")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }
}
