package com.edurumluemrullah.northwind_backend.models.dtos;

import lombok.Data;

@Data
public class UserRegisterRequestDto {

    private String username;
    private String email;
    private String password;

}
