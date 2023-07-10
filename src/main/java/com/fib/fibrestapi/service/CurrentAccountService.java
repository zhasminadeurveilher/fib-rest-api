package com.fib.fibrestapi.service;

import com.fib.fibrestapi.payload.CurrentAccountDto;

import java.util.List;

public interface CurrentAccountService {
    CurrentAccountDto addCurrentAccount(CurrentAccountDto currentAccountDto, Long customerId);
    List<CurrentAccountDto> getAllCurrentAccountsByCustomerId(Long customerId);
}
