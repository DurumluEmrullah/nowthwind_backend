package com.edurumluemrullah.northwind_backend.common.results;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class SuccessDataResult<T> extends DataResult<T>{
    public SuccessDataResult( String message, T data) {
        super(true, message, data);
    }
}
