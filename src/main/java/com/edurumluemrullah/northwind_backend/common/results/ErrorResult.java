package com.edurumluemrullah.northwind_backend.common.results;

public class ErrorResult extends Result {
    public ErrorResult( String message) {
        super(false, message);
    }
}
