package com.fib.fibrestapi.payload;

import lombok.Data;

@Data
public class CustomerSimpleInfoDto {
    private Long id;
    private String username;
    private String name;
    private String surname;
}
