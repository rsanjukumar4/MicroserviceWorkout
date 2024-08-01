package com.microservice.employeeservice.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

//    private final RestTemplate restTemplate;


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
//
//    public RestConfig(RestTemplateBuilder restTemplateBuilder) {
//        this.restTemplate = restTemplateBuilder
//                .basicAuthentication("user", "pwd")
//                .build();
//    }

//    @Bean
//    RestOperations restTemplateBuilder(RestTemplateBuilder restTemplateBuilder) {
//        return restTemplateBuilder.basicAuthentication("user", "pwd").build();
//    }
}
