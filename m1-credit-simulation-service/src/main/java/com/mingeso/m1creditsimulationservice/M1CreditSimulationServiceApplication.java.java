package com.mingeso.m1creditsimulationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class M1CreditSimulationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(M1CreditSimulationServiceApplication.class, args);
	}
}
