package com.mingeso.m2userregistrationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class M2UserRegistrationServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(M2UserRegistrationServiceApplication.class, args);
	}
}
