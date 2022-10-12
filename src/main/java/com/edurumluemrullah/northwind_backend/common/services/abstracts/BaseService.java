package com.edurumluemrullah.northwind_backend.common.services.abstracts;

import com.edurumluemrullah.northwind_backend.common.results.DataResult;
import com.edurumluemrullah.northwind_backend.common.results.Result;
import com.edurumluemrullah.northwind_backend.models.pojos.Category;

import java.util.List;

public interface BaseService<T> {

    DataResult<List<T>> getAll(int page,int size);
    DataResult<T> create(T entity);
    DataResult<T> update(T entity);
    DataResult<T> getById(int id);
    Result delete(int id);
}
