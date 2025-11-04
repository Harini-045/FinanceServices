package com.example.GenAi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "project_payment_status")
public class ProjectPaymentStatus {

    @Id
    @Column(name = "project_id")
    private String projectId;

    @Column(name = "payment_status")
    private String paymentStatus;

    // Constructors
    public ProjectPaymentStatus() {}

    public ProjectPaymentStatus(String projectId, String paymentStatus) {
        this.projectId = projectId;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
