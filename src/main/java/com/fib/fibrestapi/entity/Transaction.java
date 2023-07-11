package com.fib.fibrestapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String createdAt;

    @Column(length = 500, nullable = false)
    private String description;

    @Column(nullable = false)
    private String sender;

    @Column(name="sender_account", nullable = false)
    private String senderAccount;

    @Column(nullable = false)
    private String receiver;

    @Column(name="receiver_account", nullable = false)
    private String receiverAccount;

    private BigDecimal amount;

    //amount either to add (credit) or to subtract (credit) from the total balance
    @Column(name="is_credit", nullable = false)
    private Boolean isCredit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account_id")
    private CurrentAccount currentAccount;

    @PrePersist
    void setDefaultValues() {
        if (this.amount == null) {
            this.amount = new BigDecimal(0);
        }

        if (this.createdAt == null) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            this.createdAt = now.format(formatter);
        }
    }
}