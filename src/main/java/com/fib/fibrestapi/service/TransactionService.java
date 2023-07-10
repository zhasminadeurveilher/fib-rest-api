package com.fib.fibrestapi.service;

import com.fib.fibrestapi.payload.TransactionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    TransactionDto addTransaction(TransactionDto transactionDto, Long currentAccountId);
    List<TransactionDto> getAllTransactions(Long currentAccountId);
}

