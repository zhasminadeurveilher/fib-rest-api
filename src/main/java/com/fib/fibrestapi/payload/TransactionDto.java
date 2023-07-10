package com.fib.fibrestapi.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionDto {
    private Long id;
    private String createdAt;
    private String description;
    private String receiver;
    private String receiverAccount;
    private BigDecimal amount;
    private Boolean isCredit;
}
