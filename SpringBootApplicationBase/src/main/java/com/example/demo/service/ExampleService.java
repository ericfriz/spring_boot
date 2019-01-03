package com.example.demo.service;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class ExampleService {
    
	@Value("${node.number}")
	private int nodeNumber;
	
    @RequestMapping("/example")
    public String example() {
        return "I'm the node number: " + nodeNumber;
    }
    
}
