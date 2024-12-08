package com.mingeso.m4loanevaluationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class M4LoanEvaluationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(M4LoanEvaluationServiceApplication.class, args);
	}
}
