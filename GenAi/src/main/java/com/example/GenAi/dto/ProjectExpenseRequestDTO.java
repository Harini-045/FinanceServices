package com.example.GenAi.dto;

import java.util.List;

public class ProjectExpenseRequestDTO {
    private String projectId;
    private String companyId;
    private Double budget;
    private int projectDays;
    private List<EmployeeSalaryDTO> employees;

    public ProjectExpenseRequestDTO() {}

    public ProjectExpenseRequestDTO(String projectId, String companyId, Double budget, int projectDays, List<EmployeeSalaryDTO> employees) {
        this.projectId = projectId;
        this.companyId = companyId;
        this.budget = budget;
        this.projectDays = projectDays;
        this.employees = employees;
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

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public int getProjectDays() {
        return projectDays;
    }

    public void setProjectDays(int projectDays) {
        this.projectDays = projectDays;
    }

    public List<EmployeeSalaryDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeSalaryDTO> employees) {
        this.employees = employees;
    }
}
