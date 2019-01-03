package com.example.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	public static int nodeNumber = -1;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
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
			System.out.println("Node not correctly configured, plesse set a node number (--node.number=<num>!");
			logger.error("Node not correctly configured, plesse set a node number (--node.number=<num>!");
			throw new Exception("Node not correctly configured, plesse set a node number (--node.number=<num>!");
		}
	}
}
