package com.example.GenAi.dto;

import java.util.List;

public class ExpenseSummaryResponseDTO {
    private String projectId;
    private String companyId;
    private double commission;
    private double totalEmployeeExpense;
    private double companyBalance;
    private List<EmployeeExpenseResponseDTO> employeeExpenses;

    public ExpenseSummaryResponseDTO() {}

    public ExpenseSummaryResponseDTO(String projectId, String companyId, double commission,
                                     double totalEmployeeExpense, double companyBalance,
                                     List<EmployeeExpenseResponseDTO> employeeExpenses) {
        this.projectId = projectId;
        this.companyId = companyId;
        this.commission = commission;
        this.totalEmployeeExpense = totalEmployeeExpense;
        this.companyBalance = companyBalance;
        this.employeeExpenses = employeeExpenses;
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

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getTotalEmployeeExpense() {
        return totalEmployeeExpense;
    }

    public void setTotalEmployeeExpense(double totalEmployeeExpense) {
        this.totalEmployeeExpense = totalEmployeeExpense;
    }

    public double getCompanyBalance() {
        return companyBalance;
    }

    public void setCompanyBalance(double companyBalance) {
        this.companyBalance = companyBalance;
    }

    public List<EmployeeExpenseResponseDTO> getEmployeeExpenses() {
        return employeeExpenses;
    }

    public void setEmployeeExpenses(List<EmployeeExpenseResponseDTO> employeeExpenses) {
        this.employeeExpenses = employeeExpenses;
    }
}
