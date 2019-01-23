package com.example.demo.eurekaservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class GreetingController {

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    @Lazy
private EurekaClient eurekaClient;
    
    @GetMapping("/")
    public String greeting(){
        return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
    }


}
