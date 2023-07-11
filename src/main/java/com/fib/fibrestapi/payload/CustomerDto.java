package com.fib.fibrestapi.payload;

import lombok.Data;
import java.util.List;

@Data
public class CustomerDto {
    private Long id;
    private String username;
    private String name;
    private String surname;
    private List<CurrentAccountDto> currentAccounts;
}
