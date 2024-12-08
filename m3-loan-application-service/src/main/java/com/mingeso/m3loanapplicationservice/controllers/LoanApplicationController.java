package com.mingeso.m3loanapplicationservice.controllers;

import com.mingeso.m3loanapplicationservice.entities.LoanApplication;
import com.mingeso.m3loanapplicationservice.services.LoanApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan-applications")
public class LoanApplicationController {
    @Autowired
    private LoanApplicationService loanApplicationService;

    @PostMapping
    public LoanApplication applyForLoan(@RequestBody LoanApplication application) {
        return loanApplicationService.submitApplication(application);
    }
}
