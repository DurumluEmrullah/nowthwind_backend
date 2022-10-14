package com.edurumluemrullah.northwind_backend.common.exceptions;

public class EmailNotValidatedException extends RuntimeException{
    public EmailNotValidatedException(String message) {
        super(message);
    }
}
