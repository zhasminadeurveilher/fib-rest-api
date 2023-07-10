package com.fib.fibrestapi.service;

import com.fib.fibrestapi.payload.CustomerLoginDto;
import org.springframework.stereotype.Service;

@Service
public interface CustomerLoginService {
    String login(CustomerLoginDto customerLoginDto);
}
