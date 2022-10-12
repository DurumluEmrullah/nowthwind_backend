package com.edurumluemrullah.northwind_backend.common.services.impl;

import com.edurumluemrullah.northwind_backend.common.services.abstracts.ExceptionLogService;
import com.edurumluemrullah.northwind_backend.common.services.abstracts.ExceptionTypeService;
import com.edurumluemrullah.northwind_backend.daos.ExceptionLogDao;
import com.edurumluemrullah.northwind_backend.models.pojos.ExceptionLog;
import com.edurumluemrullah.northwind_backend.models.pojos.ExceptionType;
import com.edurumluemrullah.northwind_backend.models.pojos.dtos.CreateExceptionLogDto;
import org.springframework.stereotype.Service;


@Service
public class ExceptionLogServiceImpl implements ExceptionLogService {

    private final ExceptionLogDao exceptionLogDao;

    private final ExceptionTypeService exceptionTypeService;

    public ExceptionLogServiceImpl(ExceptionLogDao exceptionLogDao, ExceptionTypeService exceptionTypeService) {
        this.exceptionLogDao = exceptionLogDao;
        this.exceptionTypeService = exceptionTypeService;
    }

    @Override
    public ExceptionLog create(CreateExceptionLogDto exceptionLogDto) {

        ExceptionType exceptionType = exceptionTypeService.getByName(exceptionLogDto.getExceptionTypeName());
        if(exceptionType == null){
            exceptionType= new ExceptionType();
            exceptionType.setName(exceptionLogDto.getExceptionTypeName());
            exceptionType= exceptionTypeService.create(exceptionType);
        }

        ExceptionLog exceptionLog = new ExceptionLog();
        exceptionLog.setLogId(exceptionLogDto.getLogId());
        exceptionLog.setExceptionTypeId(exceptionType.getId());
        exceptionLog.setExceptionMessage(exceptionLogDto.getExceptionMessage());
        exceptionLog.setStackTrace(exceptionLogDto.getStackTrace());

        return exceptionLogDao.save(exceptionLog);
    }

    @Override
    public ExceptionLog getByLogId(int logId) {
        return exceptionLogDao.findByLogId(logId).orElse(null);
    }
}
