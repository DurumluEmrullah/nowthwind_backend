package com.edurumluemrullah.northwind_backend.common.exceptions;

public class NoAttemptException extends RuntimeException{

    public NoAttemptException(String message) {
        super(message);
    }
}
