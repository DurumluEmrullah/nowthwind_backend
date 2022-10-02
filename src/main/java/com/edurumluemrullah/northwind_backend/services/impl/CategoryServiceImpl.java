package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.common.results.DataResult;
import com.edurumluemrullah.northwind_backend.common.results.SuccessDataResult;
import com.edurumluemrullah.northwind_backend.common.services.impl.BaseServiceImpl;
import com.edurumluemrullah.northwind_backend.daos.CategoryDao;
import com.edurumluemrullah.northwind_backend.models.pojos.Category;
import com.edurumluemrullah.northwind_backend.services.abstracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        super(categoryDao);
        this.categoryDao =categoryDao;
    }


    @Override
    public DataResult<Category> create(Category category) {
        category.setCategoryId(0);
        return new SuccessDataResult<>("oluşturuldu",categoryDao.save(category));
    }

}
