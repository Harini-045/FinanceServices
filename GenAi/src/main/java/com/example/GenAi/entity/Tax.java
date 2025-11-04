package com.example.GenAi.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tax_table")
public class Tax{

    @Id
    @Column(name = "tax_id")
    private String taxId;

    private Double gst;

    @Column(name = "financial_year")
    private String financialYear;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "deducted_amount")
    private Double deductedAmount;

    @Column(name = "balance_amount")
    private Double balanceAmount;

    @Column(name = "employee_id")
    private String employeeId;

    }
