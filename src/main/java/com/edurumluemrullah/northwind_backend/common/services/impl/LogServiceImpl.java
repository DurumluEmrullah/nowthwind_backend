package com.edurumluemrullah.northwind_backend.common.services.impl;

import com.edurumluemrullah.northwind_backend.common.results.DataResult;
import com.edurumluemrullah.northwind_backend.common.results.SuccessDataResult;
import com.edurumluemrullah.northwind_backend.daos.LogDao;
import com.edurumluemrullah.northwind_backend.models.pojos.Log;
import com.edurumluemrullah.northwind_backend.common.services.abstracts.LogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    private final LogDao logDao;

    public LogServiceImpl(LogDao logDao) {
        this.logDao = logDao;
    }

    @Override
    public DataResult<Log> createLog(Log log) {
        return new SuccessDataResult<>("log eklendi",logDao.save(log));
    }


    @Override
    public DataResult<List<Log>> getAll() {
        return new SuccessDataResult<>("listelendi", logDao.findAll());
    }
}
