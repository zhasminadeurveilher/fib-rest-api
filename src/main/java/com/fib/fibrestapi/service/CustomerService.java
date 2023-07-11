package com.fib.fibrestapi.service;

import com.fib.fibrestapi.payload.CustomerDto;

public interface CustomerService {
    CustomerDto getCustomerInformation(Long customerId);
}
