package com.example.GenAi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_transaction_history")
public class EmployeeTransactionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    private Double amount;

    @Column(name = "company_id")
    private String companyId;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "ifsc_code")
    private String ifscCode;

    @Column(name = "project_id")
    private String projectId;

    @Column(name = "tax_id")
    private String taxId;
}
