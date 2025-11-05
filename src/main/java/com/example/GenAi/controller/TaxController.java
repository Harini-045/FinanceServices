package com.example.GenAi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.GenAi.dto.ExpenseSummaryResponseDTO;
import com.example.GenAi.dto.TaxDTO;
import com.example.GenAi.services.TaxService;

@RestController
@RequestMapping("/api/tax")
public class TaxController {
     @Autowired
    private TaxService taxService;

    
    @GetMapping("/all")
    public List<TaxDTO> getAllTaxes() {
        return taxService.getAllTaxes();
    }

    
    @GetMapping("/{taxId}")
    public Optional<TaxDTO> getTaxById(@PathVariable Long taxId) {
        return taxService.getTaxById(taxId);
    }  
    
    
    @PostMapping("/add")
    public TaxDTO addTax(@RequestBody TaxDTO taxDTO) {
        return taxService.addTax(taxDTO);
    }

     @PostMapping("/applyEmployeeTax")
    public List<TaxDTO> applyTaxOnEmployeeSalary(@RequestBody ExpenseSummaryResponseDTO expenseSummaryResponseDTO) {
        return taxService.applyTaxOnEmployeeSalary(expenseSummaryResponseDTO);
    }

    @PostMapping("/applyCompanyTax")
    public TaxDTO applyCompanyTax(@RequestBody ExpenseSummaryResponseDTO expenseSummaryResponseDTO) {
        return taxService.applyTaxOnCompany(expenseSummaryResponseDTO);
    }
}
