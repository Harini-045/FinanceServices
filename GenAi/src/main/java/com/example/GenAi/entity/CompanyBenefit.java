package com.example.GenAi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project_balance")
public class CompanyBenefit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "balance_id")
    private Long balanceId;

    @Column(name = "project_id")
    private String projectId;

    @Column(name = "company_id")
    private String companyId;

    @Column(name = "balance_amount")
    private Double balanceAmount;

    }
