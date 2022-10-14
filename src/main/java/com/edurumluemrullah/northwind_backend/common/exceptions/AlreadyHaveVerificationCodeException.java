package com.edurumluemrullah.northwind_backend.common.exceptions;

public class AlreadyHaveVerificationCodeException extends RuntimeException{

    public AlreadyHaveVerificationCodeException(String message) {
        super(message);
    }
}
