package com.edurumluemrullah.northwind_backend.common.exceptions;

public class VerificationCodeNotFoundException extends RuntimeException{

    public VerificationCodeNotFoundException(String message) {
        super(message);
    }
}
