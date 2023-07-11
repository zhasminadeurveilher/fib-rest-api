package com.fib.fibrestapi.controller;

import com.fib.fibrestapi.payload.CustomerDto;
import com.fib.fibrestapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/customers/{customerId}")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<CustomerDto> getCustomerInformationByCustomerId(@PathVariable Long customerId){
        CustomerDto dto = customerService.getCustomerInformation(customerId);
        return ResponseEntity.ok(dto);
    }
}