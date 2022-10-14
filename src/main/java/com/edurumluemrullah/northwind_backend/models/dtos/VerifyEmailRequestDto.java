package com.edurumluemrullah.northwind_backend.models.dtos;

import lombok.Data;

@Data
public class VerifyEmailRequestDto {
    String email;
    String verifyCode;
}
