package com.edurumluemrullah.northwind_backend.common.services.abstracts;

import com.edurumluemrullah.northwind_backend.models.pojos.ExceptionLog;
import com.edurumluemrullah.northwind_backend.models.dtos.CreateExceptionLogDto;

public interface ExceptionLogService {

    ExceptionLog create(CreateExceptionLogDto exceptionLogDto);

    ExceptionLog getByLogId(int logId);
}
