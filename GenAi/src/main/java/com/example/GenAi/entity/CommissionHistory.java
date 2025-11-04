package com.example.GenAi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "commission_history")
public class CommissionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commission_id")
    private Long commissionId;

    @Column(name = "company_id")
    private String companyId;

    @Column(name = "project_id")
    private String projectId;

    @Column(name = "commission_amount")
    private Double commissionAmount;

    public CommissionHistory() {}

    public CommissionHistory(Long commissionId, String companyId, String projectId, Double commissionAmount) {
        this.commissionId = commissionId;
        this.companyId = companyId;
        this.projectId = projectId;
        this.commissionAmount = commissionAmount;
    }

    public Long getCommissionId() {
        return commissionId;
    }

    public void setCommissionId(Long commissionId) {
        this.commissionId = commissionId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Double getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(Double commissionAmount) {
        this.commissionAmount = commissionAmount;
    }
}
