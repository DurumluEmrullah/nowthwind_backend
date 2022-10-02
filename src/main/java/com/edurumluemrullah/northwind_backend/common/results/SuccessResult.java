package com.edurumluemrullah.northwind_backend.common.results;

public class SuccessResult extends Result{

    public SuccessResult( String message) {
        super(true, message);
    }
}
