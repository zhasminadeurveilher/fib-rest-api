package com.fib.fibrestapi.service.impl;

import com.fib.fibrestapi.entity.CurrentAccount;
import com.fib.fibrestapi.entity.Transaction;
import com.fib.fibrestapi.payload.TransactionDto;
import com.fib.fibrestapi.repository.CurrentAccountRepository;
import com.fib.fibrestapi.repository.TransactionRepository;
import com.fib.fibrestapi.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CurrentAccountRepository currentAccountRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public TransactionDto addTransaction(TransactionDto transactionDto, Long currentAccountId) {
        CurrentAccount currentAccount = currentAccountRepository.findById(currentAccountId).orElseThrow(() -> new RuntimeException("Current account with id: " + currentAccountId + " not found"));

        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);

        BigDecimal amount = transaction.getAmount() == null ? new BigDecimal(0) : transaction.getAmount();

        if (!transaction.getIsCredit()) {
            //check if the amount is enough to perform the transaction if it is a debit transaction
            if (currentAccount.getBalance().subtract(amount).compareTo(new BigDecimal(0)) == -1) {
                throw new RuntimeException("Balance is not enough to perform the operation.");
            }
            currentAccount.setBalance(currentAccount.getBalance().subtract(amount));
        } else {
            currentAccount.setBalance(currentAccount.getBalance().add(amount));
        }

        //TO DO implement sender and receiver when a transaction is done from another account of different user to the current one
        if (transaction.getReceiver() == null) {
            transaction.setReceiver(transaction.getIsCredit() ? currentAccount.getCustomer().getName() + " " + currentAccount.getCustomer().getSurname() :
                    "Mr.XXX" + " " + "YYY");
        }
        if (transaction.getReceiverAccount() == null) {
            transaction.setReceiverAccount(transaction.getIsCredit() ? currentAccount.getAccountNumber() : "BEXXXXXXXXXXXXXX");
        }

        if (transaction.getSender() == null) {
            transaction.setSender(transaction.getIsCredit() ? "Mr.XXX" + " " + "YYY" : currentAccount.getCustomer().getName() + " " + currentAccount.getCustomer().getSurname());
        }

        if (transaction.getSenderAccount() == null) {
            transaction.setSenderAccount(transaction.getIsCredit() ? "BEXXXXXXXXXXXXXX" : currentAccount.getAccountNumber());
        }

        currentAccountRepository.save(currentAccount);

        transaction.setCurrentAccount(currentAccount);

        transactionRepository.save(transaction);

        return modelMapper.map(transaction, TransactionDto.class);
    }

    @Override
    public List<TransactionDto> getAllTransactions(Long currentAccountId) {
        List<Transaction> transactionsList = transactionRepository.findByCurrentAccountId(currentAccountId);
        List<TransactionDto> transactionsDtoList = new ArrayList<>();

        for (Transaction transaction : transactionsList) {
            transactionsDtoList.add(modelMapper.map(transaction, TransactionDto.class));
        }

        return transactionsDtoList;
    }
}
