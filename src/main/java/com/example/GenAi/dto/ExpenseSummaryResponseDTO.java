package com.example.GenAi.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ExpenseSummaryResponseDTO {
    private String projectId;
    private String companyId;
    private double commission;
    private double totalEmployeeExpense;
    private double companyBalance;
    private List<EmployeeExpenseResponseDTO> employeeExpenses;
}
