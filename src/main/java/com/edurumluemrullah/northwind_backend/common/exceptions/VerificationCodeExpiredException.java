package com.edurumluemrullah.northwind_backend.common.exceptions;

public class VerificationCodeExpiredException extends RuntimeException{

    public VerificationCodeExpiredException(String message) {
        super(message);
    }
}
