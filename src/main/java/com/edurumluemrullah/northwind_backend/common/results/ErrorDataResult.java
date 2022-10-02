package com.edurumluemrullah.northwind_backend.common.results;

public class ErrorDataResult<T> extends DataResult<T> {

    public ErrorDataResult( String message, T data) {
        super(false, message, data);
    }
}
