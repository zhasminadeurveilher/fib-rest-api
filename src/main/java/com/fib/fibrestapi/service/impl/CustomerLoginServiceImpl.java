package com.fib.fibrestapi.service.impl;

import com.fib.fibrestapi.payload.CustomerLoginDto;
import com.fib.fibrestapi.service.CustomerLoginService;

public class CustomerLoginServiceImpl implements CustomerLoginService {
    @Override
    public String login(CustomerLoginDto customerLoginDto) {
        return "ok";
    }
}