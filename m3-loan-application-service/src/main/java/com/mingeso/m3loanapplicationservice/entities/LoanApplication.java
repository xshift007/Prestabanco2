package com.mingeso.m3loanapplicationservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "loan_applications")
@Getter
@Setter
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private double amount;
    private int termInMonths;
    private String status; // PENDING, APPROVED, REJECTED
}
