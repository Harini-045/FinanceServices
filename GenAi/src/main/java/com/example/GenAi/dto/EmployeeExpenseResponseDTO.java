package com.example.GenAi.dto;

public class EmployeeExpenseResponseDTO {
    private String employeeId;
    private Double totalSalaryExpense;

    public EmployeeExpenseResponseDTO() {}

    public EmployeeExpenseResponseDTO(String employeeId, Double totalSalaryExpense) {
        this.employeeId = employeeId;
        this.totalSalaryExpense = totalSalaryExpense;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Double getTotalSalaryExpense() {
        return totalSalaryExpense;
    }

    public void setTotalSalaryExpense(Double totalSalaryExpense) {
        this.totalSalaryExpense = totalSalaryExpense;
    }
}
