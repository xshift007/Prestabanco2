package com.mingeso.m4loanevaluationservice.controllers;

import com.mingeso.m4loanevaluationservice.services.LoanEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan-evaluation")
public class LoanEvaluationController {

    @Autowired
    private LoanEvaluationService loanEvaluationService;

    @PostMapping("/{applicationId}")
    public String evaluate(@PathVariable Long applicationId) {
        return loanEvaluationService.evaluateLoanApplication(applicationId);
    }
}
