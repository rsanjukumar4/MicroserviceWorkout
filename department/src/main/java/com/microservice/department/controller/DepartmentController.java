package com.microservice.department.controller;

import com.microservice.department.entity.Department;
import com.microservice.department.exception.DepartmentNotFoundException;
import com.microservice.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("/save")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.findByDepartmentId(id);
    }

    @GetMapping("/get-all")
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable Long id) {

        return departmentService.deleteDepartmentById(id);
    }

}
