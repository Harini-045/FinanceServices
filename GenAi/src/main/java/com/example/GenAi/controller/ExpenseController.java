package com.example.GenAi.controller;

import com.example.GenAi.dto.ProjectExpenseRequestDTO;
import com.example.GenAi.dto.ExpenseSummaryResponseDTO;
import com.example.GenAi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/finance")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/process-expense")
    public ResponseEntity<ExpenseSummaryResponseDTO> processExpense(@RequestBody ProjectExpenseRequestDTO request) {
        ExpenseSummaryResponseDTO response = expenseService.processProjectExpense(request);
        return ResponseEntity.ok(response);
    }
}
