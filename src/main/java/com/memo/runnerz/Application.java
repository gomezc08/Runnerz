package com.memo.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) { 
		SpringApplication.run(Application.class, args);		// uses springapplication.run method to run our current application.
		log.info("ran successfully!");
	}
} 