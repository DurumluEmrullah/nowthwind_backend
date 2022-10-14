package com.edurumluemrullah.northwind_backend.common.exceptions;

public class WrongVerifcationCodeException extends RuntimeException{

    public WrongVerifcationCodeException(String message) {
        super(message);
    }
}
