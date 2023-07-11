package com.fib.fibrestapi.service;

import com.fib.fibrestapi.payload.CustomerDto;
import com.fib.fibrestapi.payload.CustomerSimpleInfoDto;

public interface CustomerService {
    CustomerDto getCustomerInformation(Long customerId);
    CustomerSimpleInfoDto findByUsername(String username);
}
