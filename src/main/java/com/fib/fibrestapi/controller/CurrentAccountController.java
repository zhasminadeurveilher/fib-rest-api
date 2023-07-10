package com.fib.fibrestapi.controller;

import com.fib.fibrestapi.payload.CurrentAccountDto;
import com.fib.fibrestapi.service.CurrentAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/customers/{customerId}/currentaccounts")
public class CurrentAccountController {
    @Autowired
    private CurrentAccountService currentAccountService;

    @PostMapping
    public ResponseEntity<CurrentAccountDto> addCurrentAccount(@RequestBody CurrentAccountDto currentAccountDto, @PathVariable Long customerId) {
        CurrentAccountDto savedCurrentAccount = currentAccountService.addCurrentAccount(currentAccountDto, customerId);
        return new ResponseEntity<>(savedCurrentAccount, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CurrentAccountDto>> getCurrentAccountsByCustomerId(@PathVariable Long customerId){
        List<CurrentAccountDto> dtoList = currentAccountService.getAllCurrentAccountsByCustomerId(customerId);
        return ResponseEntity.ok(dtoList);
    }
}

