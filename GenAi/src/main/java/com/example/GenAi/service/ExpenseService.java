package com.example.GenAi.service;

import com.example.GenAi.dto.*;
import com.example.GenAi.entity.CommissionHistory;
import com.example.GenAi.entity.CompanyBenefit;
import com.example.GenAi.repository.CommissionHistoryRepository;
import com.example.GenAi.repository.CompanyBenefitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    @Autowired
    private CommissionHistoryRepository commissionRepo;

    @Autowired
    private CompanyBenefitRepository benefitRepo;

     // Optional, useful for future mapping needs

    public ExpenseSummaryResponseDTO processProjectExpense(ProjectExpenseRequestDTO request) {

        String projectId = request.getProjectId();
        String companyId = request.getCompanyId();
        Double budget = request.getBudget();
        int projectDays = request.getProjectDays();

        // 1️⃣ Calculate each employee's total salary expense = dailySalary * projectDays
        List<EmployeeExpenseResponseDTO> employeeExpenses = request.getEmployees()
                .stream()
                .map(emp -> {
                    double totalSalary = emp.getDailySalary() * projectDays;
                    return new EmployeeExpenseResponseDTO(emp.getEmployeeId(), totalSalary);
                })
                .collect(Collectors.toList());

        // 2️⃣ Calculate total employee expense
        double totalEmployeeExpense = employeeExpenses.stream()
                .mapToDouble(EmployeeExpenseResponseDTO::getTotalSalaryExpense)
                .sum();

        // 3️⃣ Calculate 10% commission from budget
        double commission = budget * 0.10;

        // Save commission in DB
        CommissionHistory commissionHistory = new CommissionHistory();
        commissionHistory.setCompanyId(companyId);
        commissionHistory.setProjectId(projectId);
        commissionHistory.setCommissionAmount(commission);
        commissionRepo.save(commissionHistory);

        // 4️⃣ Calculate company balance (remaining profit)
        double companyBalance = budget - (commission + totalEmployeeExpense);

        // Save company balance in DB
        CompanyBenefit benefit = new CompanyBenefit();
        benefit.setCompanyId(companyId);
        benefit.setProjectId(projectId);
        benefit.setBalanceAmount(companyBalance);
        benefitRepo.save(benefit);

        // 5️⃣ Build Response DTO
        ExpenseSummaryResponseDTO response = new ExpenseSummaryResponseDTO();
        response.setProjectId(projectId);
        response.setCompanyId(companyId);
        response.setCommission(commission);
        response.setTotalEmployeeExpense(totalEmployeeExpense);
        response.setCompanyBalance(companyBalance);
        response.setEmployeeExpenses(employeeExpenses);

        return response;
    }
}
