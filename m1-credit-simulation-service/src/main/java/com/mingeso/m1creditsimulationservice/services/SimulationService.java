package com.mingeso.m1creditsimulationservice.services;

import org.springframework.stereotype.Service;

@Service
public class SimulationService {
    public double calculateMonthlyInstallment(double amount, int termInMonths, double annualInterestRate) {
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        return (amount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -termInMonths));
    }
}
