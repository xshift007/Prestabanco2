package com.mingeso.m3loanapplicationservice.repositories;

import com.mingeso.m3loanapplicationservice.entities.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
}
