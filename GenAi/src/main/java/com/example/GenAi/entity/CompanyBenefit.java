package com.example.GenAi.entity;

import jakarta.persistence.*;

@Entity
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

    public CompanyBenefit() {}

    public CompanyBenefit(Long balanceId, String projectId, String companyId, Double balanceAmount) {
        this.balanceId = balanceId;
        this.projectId = projectId;
        this.companyId = companyId;
        this.balanceAmount = balanceAmount;
    }

    public Long getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Long balanceId) {
        this.balanceId = balanceId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public Double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(Double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }
}
