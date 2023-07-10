package com.fib.fibrestapi.service.impl;

import com.fib.fibrestapi.entity.CurrentAccount;
import com.fib.fibrestapi.entity.Customer;
import com.fib.fibrestapi.payload.CurrentAccountDto;
import com.fib.fibrestapi.repository.CurrentAccountRepository;
import com.fib.fibrestapi.repository.CustomerRepository;
import com.fib.fibrestapi.service.CurrentAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrentAccountServiceImpl implements CurrentAccountService {
    CurrentAccountRepository currentAccountRepository;
    CustomerRepository customerRepository;
    ModelMapper modelMapper;

    public CurrentAccountServiceImpl(CurrentAccountRepository currentAccountRepository, CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.currentAccountRepository = currentAccountRepository;
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CurrentAccountDto addCurrentAccount(CurrentAccountDto currentAccountDto, Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer with id: " + customerId + " not found"));

        CurrentAccount currentAccount = modelMapper.map(currentAccountDto, CurrentAccount.class);
        currentAccount.setCustomer(customer);

        currentAccountRepository.save(currentAccount);

        return modelMapper.map(currentAccount, CurrentAccountDto.class);
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
