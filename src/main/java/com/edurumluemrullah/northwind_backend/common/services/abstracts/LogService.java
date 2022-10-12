package com.edurumluemrullah.northwind_backend.common.services.abstracts;

import com.edurumluemrullah.northwind_backend.common.results.DataResult;
import com.edurumluemrullah.northwind_backend.common.results.Result;
import com.edurumluemrullah.northwind_backend.models.pojos.Log;

import java.util.List;

public interface LogService {

    DataResult<Log> createLog(Log log);

    DataResult<List<Log>> getAll();
}
