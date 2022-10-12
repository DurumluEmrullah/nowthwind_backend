package com.edurumluemrullah.northwind_backend.common.services.abstracts;


import com.edurumluemrullah.northwind_backend.models.pojos.ExceptionType;

public interface ExceptionTypeService {

    ExceptionType getById(int id);
    ExceptionType getByName(String name);
    ExceptionType create(ExceptionType exceptionType);
}
