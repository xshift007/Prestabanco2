package com.mingeso.m4loanevaluationservice.services;

import org.springframework.stereotype.Service;

@Service
public class LoanEvaluationService {
    public String evaluateLoanApplication(Long applicationId) {
        // lógica de evaluación
        return "APPROVED";
    }
}
