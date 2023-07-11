package com.fib.fibrestapi.controller;

import com.fib.fibrestapi.payload.CustomerLoginDto;
import com.fib.fibrestapi.payload.JwtAuthResponse;
import com.fib.fibrestapi.service.CustomerLoginService;
import com.fib.fibrestapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class CustomerLoginController {
    @Autowired
    private CustomerLoginService customerLoginService;
    @Autowired
    private CustomerService customerService;

    //Build Login REST API
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody CustomerLoginDto customerLoginDto){
        String token = customerLoginService.login(customerLoginDto);

        JwtAuthResponse jwtAuthResponseDto = new JwtAuthResponse();
        jwtAuthResponseDto.setAccessToken(token);
        jwtAuthResponseDto.setCustomerId(customerService.findByUsername(customerLoginDto.getUsername()).getId());

        return ResponseEntity.ok(jwtAuthResponseDto);
    }
}
