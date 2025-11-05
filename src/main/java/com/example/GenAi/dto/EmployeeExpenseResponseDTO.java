package com.example.GenAi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeExpenseResponseDTO {
    private String employeeId;
    private Double totalSalaryExpense;

}
