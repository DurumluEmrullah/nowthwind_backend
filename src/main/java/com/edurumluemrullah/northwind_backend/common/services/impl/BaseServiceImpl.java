package com.edurumluemrullah.northwind_backend.common.services.impl;

import com.edurumluemrullah.northwind_backend.common.results.*;
import com.edurumluemrullah.northwind_backend.common.services.abstracts.BaseService;
import com.edurumluemrullah.northwind_backend.models.pojos.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<T> implements BaseService<T> {


    private final JpaRepository jpaRepository;

    public BaseServiceImpl(JpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public DataResult<List<T>> getAll() {

        return new SuccessDataResult<>("listelendi",jpaRepository.findAll());
    }

    @Override
    public DataResult<T> create(T entity) {
        return new SuccessDataResult<T>("oluşturuldu",(T)jpaRepository.save(entity));
    }

    @Override
    public DataResult<T> update(T entity) {
        return new SuccessDataResult<T>("güncellendi",(T)jpaRepository.save(entity));
    }

    @Override
    public DataResult<T> getById(int id) {
        DataResult<T> result = new ErrorDataResult<>("bulunamadı",null);
        Optional<T> entity = jpaRepository.findById(id);
        if (entity.isPresent()){
            result= new SuccessDataResult<>("listelendi",entity.get());
        }

        return result;
    }

    @Override
    public Result delete(int id) {
        DataResult<T> result = getById(id);

        if(result.isSuccess()){
            jpaRepository.delete(result.getData());
            result.setMessage("silindi");
        }

        return result;
    }
}
