package com.fib.fibrestapi.payload;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CurrentAccountDto {
    private Long id;
    private String name;
    private String currency;
    private String accountNumber;
    private BigDecimal balance;
    private BigDecimal initialCredit;
    private List<TransactionDto> transactions;
}
