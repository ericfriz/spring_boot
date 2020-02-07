package com.example.micro1.service;

import org.springframework.web.bind.annotation.RestController;

import com.example.micro1.model.People;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class Service1Impl implements Service1{
    
	@Value("${node.number}")
	private int nodeNumber;
	
	@Value("${micro.version}")
	private String microVersion;
	
    @RequestMapping(value="/whoAmI",  method = RequestMethod.GET)
    public String whoAmI() {
        return "I'm the node number: " + nodeNumber;
    }

    @RequestMapping(value="/getNodeNumber",  method = RequestMethod.GET)
	public int getNodeNumber() {
	   return nodeNumber;
	}

    @RequestMapping(value="/getVersion",  method = RequestMethod.GET)
	public String getVersion() {
		return microVersion;
	}

    @RequestMapping(value="/getPeople",  method = RequestMethod.GET)
	public People getPeople(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}
  
}