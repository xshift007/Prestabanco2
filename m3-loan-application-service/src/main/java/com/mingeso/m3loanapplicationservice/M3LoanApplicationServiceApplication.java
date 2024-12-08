package com.mingeso.m3loanapplicationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class M3LoanApplicationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(M3LoanApplicationServiceApplication.class, args);
	}
}
