package com.fib.fibrestapi.service.impl;

import com.fib.fibrestapi.entity.CurrentAccount;
import com.fib.fibrestapi.entity.Customer;
import com.fib.fibrestapi.payload.CurrentAccountDto;
import com.fib.fibrestapi.payload.TransactionDto;
import com.fib.fibrestapi.repository.CurrentAccountRepository;
import com.fib.fibrestapi.repository.CustomerRepository;
import com.fib.fibrestapi.repository.TransactionRepository;
import com.fib.fibrestapi.service.CurrentAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CurrentAccountServiceImpl implements CurrentAccountService {
    @Autowired
    CurrentAccountRepository currentAccountRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private TransactionServiceImpl transactionService;

    @Override
    public CurrentAccountDto addCurrentAccount(CurrentAccountDto currentAccountDto, Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer with id: " + customerId + " not found"));

        CurrentAccount currentAccount = modelMapper.map(currentAccountDto, CurrentAccount.class);
        currentAccount.setCustomer(customer);
        //generate random number for the current account
        long randomNumber = new Date().getTime();
        currentAccount.setAccountNumber("BE" + randomNumber);
        currentAccountRepository.save(currentAccount);

        if(currentAccountDto.getInitialCredit().compareTo(new BigDecimal(0)) == 1){
            TransactionDto transactionDto = new TransactionDto();
            transactionDto.setDescription("Initial Transaction");
            transactionDto.setSender(customer.getName() + " " + customer.getSurname());
            //TO DO implement sender as a list of created current accounts
            transactionDto.setSenderAccount("BEXXXXXXXXXXXXXX");
            transactionDto.setReceiver(customer.getName() + " " + customer.getSurname());
            transactionDto.setReceiverAccount(currentAccount.getAccountNumber());
            transactionDto.setAmount(currentAccountDto.getInitialCredit());
            transactionDto.setIsCredit(true);

            transactionService.addTransaction(transactionDto, currentAccount.getId());
        }

        CurrentAccountDto dto = modelMapper.map(currentAccount, CurrentAccountDto.class);
        dto.setInitialCredit(currentAccountDto.getInitialCredit());

        return dto;
    }

    @Override
    public List<CurrentAccountDto> getAllCurrentAccountsByCustomerId(Long customerId) {
        //check if the current account is the same as the logged in customer
        List<CurrentAccount> currentAccountsList = currentAccountRepository.findByCustomerId(customerId);

        List<CurrentAccountDto> currentAccountsDtoList = new ArrayList<>();
        for (CurrentAccount currentAccount : currentAccountsList) {
            currentAccountsDtoList.add(modelMapper.map(currentAccount, CurrentAccountDto.class));
        }
        return currentAccountsDtoList;
    }
}
