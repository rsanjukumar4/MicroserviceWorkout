package com.microservice.department.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
public class ApplicationController {

    @GetMapping("/welcome")
//    @PreAuthorize("hasRole('USER')")
    public String welcome() {
        return "Hey! welcome to GeeksforGeeks";
    }

}