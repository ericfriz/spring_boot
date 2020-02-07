package com.example.micro1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.core.env.Environment;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


@OpenAPIDefinition (info = 
@Info(
          title = "micro1 API",
          version =  "1.0",
          description = "micro1 API description",
          license = @License(name = "Apache 2.0", url = "http://exampleUrl")
  )
)

@SpringBootApplication
public class Micro1Application implements ApplicationRunner{

private static final Logger logger = LoggerFactory.getLogger(Micro1Application.class);

    @Value("${node.number}")
	public int nodeNumber;
    
     @Autowired
    private Environment env;
    
	public static void main(String[] args) {
		SpringApplication.run(Micro1Application.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
		logger.info("NonOptionArgs: {}", args.getNonOptionArgs());
		logger.info("OptionNames: {}", args.getOptionNames());

		for (String name : args.getOptionNames()) {
			logger.info("arg-" + name + "=" + args.getOptionValues(name));
		}

		boolean containsOption = args.containsOption("node.number");
		logger.info("Contains node.number: " + containsOption);

		if (!containsOption) {
			System.out.println("Node isn't configured via command line (--node.number=<num>!");
			logger.warn("Node isn't configured via command line (--node.number=<num>!");
		}
		System.out.println("Node number value = " + nodeNumber);
		logger.info("Node number value = " + nodeNumber);
	}
	
}
