package com.fib.fibrestapi.service.impl;

import com.fib.fibrestapi.entity.Customer;
import com.fib.fibrestapi.payload.CustomerDto;
import com.fib.fibrestapi.repository.CustomerRepository;
import com.fib.fibrestapi.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public CustomerDto getCustomerInformation(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer with id: " + customerId + " not found"));
        return modelMapper.map(customer, CustomerDto.class);
    }
}
