package com.fib.fibrestapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {
    private Long id;
    private String createdAt;
    private String description;
    private String sender;
    private String senderAccount;
    private String receiver;
    private String receiverAccount;
    private BigDecimal amount;
    private Boolean isCredit;
}
