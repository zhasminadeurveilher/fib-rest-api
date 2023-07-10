package com.fib.fibrestapi.repository;

import com.fib.fibrestapi.entity.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {
    List<CurrentAccount> findByCustomerId(Long customerId);
}

