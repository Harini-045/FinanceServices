package com.example.GenAi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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


   
}
