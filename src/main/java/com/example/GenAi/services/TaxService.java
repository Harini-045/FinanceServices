package com.example.GenAi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GenAi.dto.EmployeeExpenseResponseDTO;
import com.example.GenAi.dto.ExpenseSummaryResponseDTO;
import com.example.GenAi.dto.TaxDTO;
import com.example.GenAi.entity.Tax;
import com.example.GenAi.repository.TaxRepository;

@Service
public class TaxService {
     @Autowired
    private TaxRepository taxRepository;

    //  Add new tax (input & output in DTO)
    public TaxDTO addTax(TaxDTO taxDTO) {
        Tax tax = new Tax();

        BeanUtils.copyProperties(taxDTO, tax);

        Tax savedTax = taxRepository.save(tax);

        TaxDTO responseDTO = new TaxDTO();
        BeanUtils.copyProperties(savedTax, responseDTO);

        return responseDTO;
    }

    //  Get all taxes (return list of DTOs)
    public List<TaxDTO> getAllTaxes() {
        return taxRepository.findAll().stream().map(tax -> {
            TaxDTO dto = new TaxDTO();
            BeanUtils.copyProperties(tax, dto);
            return dto;
        }).collect(Collectors.toList());
    }

    //  Get tax by ID (return DTO)
    public Optional<TaxDTO> getTaxById(Long taxId) {
        return taxRepository.findById(taxId).map(tax -> {
            TaxDTO dto = new TaxDTO();
            BeanUtils.copyProperties(tax, dto);
            return dto;
        });
    }

    public List<TaxDTO> applyTaxOnEmployeeSalary(ExpenseSummaryResponseDTO expenseSummaryResponseDTO) {

        List<TaxDTO> taxResponses = new ArrayList<>();

        for (EmployeeExpenseResponseDTO employeeExpense : expenseSummaryResponseDTO.getEmployeeExpenses()) {

            double employeeTotalSalary = employeeExpense.getTotalSalaryExpense();

            //  Determine tax rate
            double taxPercentage;
            if (employeeTotalSalary <= 50000) {
                taxPercentage = 5.0;
            } else if (employeeTotalSalary <= 100000) {
                taxPercentage = 10.0;
            } else {
                taxPercentage = 15.0;
            }

            //  Calculate amounts
            double taxAmount = (employeeTotalSalary * taxPercentage) / 100;
            double balance = employeeTotalSalary - taxAmount;

            //  Create and save entity
            Tax tax = new Tax();
            tax.setGst(taxPercentage);
            tax.setFinancialYear("2024-2025");
            tax.setTotalAmount(employeeTotalSalary);
            tax.setDeductedAmount(taxAmount);
            tax.setBalanceAmount(balance);
            tax.setEmployeeId(employeeExpense.getEmployeeId());
            tax.setCompanyId(expenseSummaryResponseDTO.getCompanyId());
            tax.setProjectId(expenseSummaryResponseDTO.getProjectId());

            Tax savedTax =taxRepository.save(tax);

            TaxDTO dto = new TaxDTO();
            BeanUtils.copyProperties(savedTax, dto);
            taxResponses.add(dto);
        }

        return taxResponses;
    }

    public TaxDTO applyTaxOnCompany(ExpenseSummaryResponseDTO expenseSummaryResponseDTO) {

        double companyBalance = expenseSummaryResponseDTO.getCompanyBalance();

        //  Apply GST of 18%
        double gstPercentage = 18.0;
        double taxAmount = (companyBalance * gstPercentage) / 100;
        double balanceAfterTax = companyBalance - taxAmount;

        //  Create tax entry (employeeId = null)
        Tax tax = new Tax();
        tax.setGst(gstPercentage);
        tax.setFinancialYear("2024-2025");
        tax.setTotalAmount(companyBalance);
        tax.setDeductedAmount(taxAmount);
        tax.setBalanceAmount(balanceAfterTax);
        tax.setEmployeeId(null); // No employee
        tax.setCompanyId(expenseSummaryResponseDTO.getCompanyId());
        tax.setProjectId(expenseSummaryResponseDTO.getProjectId());

        Tax savedTax = taxRepository.save(tax);

        // Convert entity to DTO
        TaxDTO dto = new TaxDTO();
        BeanUtils.copyProperties(savedTax, dto);

        return dto;
    }
}
