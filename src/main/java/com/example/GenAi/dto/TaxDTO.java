package com.example.GenAi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaxDTO {
    private Double gst;
    private String financialYear;
    private Double totalAmount;
    private Double deductedAmount;
    private Double balanceAmount;
    private String employeeId;
    private String companyId;
    private String projectId;
}
