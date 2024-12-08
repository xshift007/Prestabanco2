package com.mingeso.m1creditsimulationservice.controllers;

import com.mingeso.m1creditsimulationservice.services.SimulationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simulate")
public class SimulationController {

    private final SimulationService simulationService;

    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @PostMapping
    public double simulateLoan(
            @RequestParam double amount,
            @RequestParam int termInMonths,
            @RequestParam double annualInterestRate) {

        return simulationService.calculateMonthlyInstallment(amount, termInMonths, annualInterestRate);
    }
}
