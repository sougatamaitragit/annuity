package com.lendico.exam.schedule.repayment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * This class is responsible for loading Spring Boot Application
 * Default embedded server is used for running the application
 * @author Sougata Maitra
 * @version 1.0
 */

@SpringBootApplication
public class ApplicationRunner {
	
	public static void main(String args[]) {
		SpringApplication.run(ApplicationRunner.class, args);
	}

}
