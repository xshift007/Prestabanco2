package com.example.creditsimulation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Clase principal del microservicio de simulación de créditos.
 * Se habilita EurekaClient para registro futuro en Eureka Server.
 */
@SpringBootApplication
@EnableEurekaClient
public class M1CreditSimulationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(M1CreditSimulationServiceApplication.class, args);
	}

}
