package com.edurumluemrullah.northwind_backend.common.services.impl;

import com.edurumluemrullah.northwind_backend.common.services.abstracts.ExceptionTypeService;
import com.edurumluemrullah.northwind_backend.daos.ExceptionTypeDao;
import com.edurumluemrullah.northwind_backend.models.pojos.ExceptionType;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExceptionTypeServiceImp implements ExceptionTypeService {

    private final ExceptionTypeDao exceptionTypeDao;

    public ExceptionTypeServiceImp(ExceptionTypeDao exceptionTypeDao) {
        this.exceptionTypeDao = exceptionTypeDao;
    }

    @Override
    public ExceptionType getById(int id) {

        Optional<ExceptionType> exceptionTypeOptional = exceptionTypeDao.findById(id);

        return exceptionTypeOptional.orElse(null);

    }

    @Override
    public ExceptionType getByName(String name) {

        Optional<ExceptionType> exceptionTypeOptional = exceptionTypeDao.findByName(name.trim());

        return exceptionTypeOptional.orElse(null);
    }

    @Override
    public ExceptionType create(ExceptionType exceptionType) {
        ExceptionType type = getByName(exceptionType.getName());
        if(type==null){
            type= exceptionTypeDao.save(exceptionType);
        }

        return type;
    }
}
