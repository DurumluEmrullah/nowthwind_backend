package com.edurumluemrullah.northwind_backend.models.dtos;

import lombok.Data;

@Data
public class UserLoginResponseDto {

    private String username;
    private String email;
    private String token;
    // other information

}
