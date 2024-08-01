package com.microservice.department.exception;

public class DepartmentNotFoundException extends Exception{

    public DepartmentNotFoundException(Long id) {
        super(" Department Not found with Id: "   +id);
    }
}
