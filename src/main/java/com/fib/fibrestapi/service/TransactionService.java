package com.fib.fibrestapi.service;

import com.fib.fibrestapi.payload.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionDto addTransaction(TransactionDto transactionDto, Long currentAccountId);
    List<TransactionDto> getAllTransactions(Long currentAccountId);
}

