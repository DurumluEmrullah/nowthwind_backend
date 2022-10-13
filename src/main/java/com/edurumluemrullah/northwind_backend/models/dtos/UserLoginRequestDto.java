package com.edurumluemrullah.northwind_backend.models.dtos;

import lombok.Data;

@Data
public class UserLoginRequestDto {

    private String username;
    private String password;
}
