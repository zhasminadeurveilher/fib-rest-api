package com.fib.fibrestapi.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrentAccountDto {
    private Long id;
    private String name;
    private String currency;
    private String accountNumber;
    private BigDecimal balance;
    private BigDecimal initialCredit;
}
