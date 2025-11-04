package com.example.GenAi.dto;

public class EmployeeSalaryDTO {
    private String employeeId;
    private Double dailySalary;

    public EmployeeSalaryDTO() {}

    public EmployeeSalaryDTO(String employeeId, Double dailySalary) {
        this.employeeId = employeeId;
        this.dailySalary = dailySalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Double getDailySalary() {
        return dailySalary;
    }

    public void setDailySalary(Double dailySalary) {
        this.dailySalary = dailySalary;
    }
}
