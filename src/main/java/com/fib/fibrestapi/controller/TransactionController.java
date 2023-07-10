package com.fib.fibrestapi.controller;

import com.fib.fibrestapi.payload.TransactionDto;
import com.fib.fibrestapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/customers/{customerId}/currentaccounts/{currentAccountId}/transactions")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping
    ResponseEntity<List<TransactionDto>> getTransactionsByCurrentAccountId(@PathVariable Long currentAccountId){
        List<TransactionDto> transactionsList = transactionService.getAllTransactions(currentAccountId);
        return ResponseEntity.ok(transactionsList);
    }

    @PostMapping
    ResponseEntity<TransactionDto> addTransaction(@RequestBody TransactionDto transactionDto, @PathVariable Long currentAccountId){
        TransactionDto transactionToSend = transactionService.addTransaction(transactionDto, currentAccountId);
        return new ResponseEntity<>(transactionToSend, HttpStatus.CREATED);
    }
}
