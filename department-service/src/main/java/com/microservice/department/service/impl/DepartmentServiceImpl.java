package com.microservice.department.service.impl;

import com.microservice.department.entity.Department;
import com.microservice.department.exception.DepartmentNotFoundException;
import com.microservice.department.repository.DepartmentRepository;
import com.microservice.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        log.info("Save department");
        return departmentRepository.save(department);
    }

    @Override
    @Cacheable(value = "department", key = "#departmentId")
    public Department findByDepartmentId(Long departmentId) throws DepartmentNotFoundException {
        log.info("Find department by Id");
        Department department = departmentRepository.findByDepartmentId(departmentId);
        if(Objects.isNull(department)) {
            throw new DepartmentNotFoundException(departmentId);
        }
        return department;
    }

    @Override
    public List<Department> findAll() {
        log.info("Find all departments");
        return departmentRepository.findAll();
    }

    @Override
    @CacheEvict(value = "department", key = "#departmentId")
    public String deleteDepartmentById(Long departmentId) {
        log.info("Delete Department By Id");
        departmentRepository.deleteById(departmentId);
        return "Employee with ID " + departmentId + " deleted successfully.";
    }
}
