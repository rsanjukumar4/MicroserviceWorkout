package com.microservice.department.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DepartmentExceptionHandler {
    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDepartmentNotFoundException(DepartmentNotFoundException exception){
        var apiResponse = new ErrorResponse();
        apiResponse.setErrorCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
        apiResponse.setMessage(exception.getMessage());
        return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);


    }




}
