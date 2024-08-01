package com.microservice.employeeservice.service.impl;

import com.microservice.employeeservice.entity.Department;
import com.microservice.employeeservice.entity.Employee;
import com.microservice.employeeservice.entity.ResponseTemplate;
import com.microservice.employeeservice.repository.EmployeeRepository;
import com.microservice.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final RestTemplate restTemplate;

    @Override
    public Employee saveEmployee(Employee employee) {
        log.info("save employee method");
        return employeeRepository.save(employee);
    }

    @Override
    public ResponseTemplate getEmployeeWithDepartment(Long employeeId) {
        ResponseTemplate responseTemplate = new ResponseTemplate();
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        responseTemplate.setEmployee(employee);
        String url = "http://localhost:8081/department/" + employee.getDepartmentId();
//        Department department = restTemplate.getForObject(
//                "http://localhost:8081/department/" + employee.getDepartmentId(),
//                Department.class);

        Department department = fetchDepartmentResponse(url);
        responseTemplate.setDepartment(department);
        return responseTemplate;
    }

    private Department fetchDepartmentResponse(String url) {
        String plainCreds = "user:pwd";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        HttpEntity<String> request = new HttpEntity<String>(headers);
        ResponseEntity<Department> response = restTemplate.exchange(url, HttpMethod.GET,request, Department.class);
        return response.getBody();
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

}
