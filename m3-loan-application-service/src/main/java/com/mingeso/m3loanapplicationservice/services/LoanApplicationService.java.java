package com.mingeso.m3loanapplicationservice.services;

import com.mingeso.m3loanapplicationservice.entities.LoanApplication;
import com.mingeso.m3loanapplicationservice.repositories.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationService {
    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    public LoanApplication submitApplication(LoanApplication application) {
        application.setStatus("PENDING");
        return loanApplicationRepository.save(application);
    }
}
