package com.fib.fibrestapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
@Table(name="current_account")
public class CurrentAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currency;

    @Column(nullable = false)
    private String name;

    @Column(name="account_number", nullable = false, unique = true)
    private String accountNumber;

    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @PrePersist
    @PreUpdate
    void setDefaultValues() {
        if (this.balance == null) {
            this.balance = new BigDecimal(0);
        }

        if (this.currency == null) {
            this.currency = "EUR";
        }
    }
}
