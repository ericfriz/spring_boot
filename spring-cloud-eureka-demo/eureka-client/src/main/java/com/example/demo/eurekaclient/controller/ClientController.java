package com.example.demo.eurekaclient.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

	@Autowired
	private EurekaClient eurekaClient;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

	@GetMapping("/")
	public String invokeService() {
		RestTemplate restTemplate = restTemplateBuilder.build();
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("eureka-service", false);

		logger.info("HOSTNAME: " + instanceInfo.getHostName());
		logger.info("PORT: " + instanceInfo.getPort());

		String serviceBaseUrl = instanceInfo.getHomePageUrl();
		logger.info("serviceBaseUrl: " + serviceBaseUrl);
		String result = restTemplate.getForObject(serviceBaseUrl, String.class);
		
		String output = result + " HOSTNAME: " + instanceInfo.getHostName() +
				                 " PORT: " + instanceInfo.getPort();
		logger.info("result: " + result);
		return output;
	}
}
