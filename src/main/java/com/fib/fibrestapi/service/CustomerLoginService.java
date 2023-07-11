package com.fib.fibrestapi.service;

import com.fib.fibrestapi.payload.CustomerLoginDto;


public interface CustomerLoginService {
    String login(CustomerLoginDto customerLoginDto);
}
