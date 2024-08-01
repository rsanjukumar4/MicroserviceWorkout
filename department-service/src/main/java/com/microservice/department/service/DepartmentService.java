package com.microservice.department.service;

import com.microservice.department.entity.Department;
import com.microservice.department.exception.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    Department saveDepartment(Department department);

    Department findByDepartmentId(Long departmentId) throws DepartmentNotFoundException;

    List<Department> findAll();

    String deleteDepartmentById(Long id);
}
