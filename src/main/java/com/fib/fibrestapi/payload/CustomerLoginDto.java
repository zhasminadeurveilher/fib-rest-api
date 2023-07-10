package com.fib.fibrestapi.payload;

import lombok.Data;

@Data
public class CustomerLoginDto {
    private String username;
    private String password;
}
