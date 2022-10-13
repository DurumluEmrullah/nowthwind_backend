package com.edurumluemrullah.northwind_backend.models.dtos;

import lombok.Data;

@Data
public class CreateExceptionLogDto {

    private int logId;
    private String exceptionTypeName;
    private String exceptionMessage;
    private String stackTrace;
}
