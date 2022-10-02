package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.common.services.impl.BaseServiceImpl;
import com.edurumluemrullah.northwind_backend.daos.ProductDao;
import com.edurumluemrullah.northwind_backend.models.pojos.Product;
import com.edurumluemrullah.northwind_backend.services.abstracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductServiceImpl( ProductDao productDao) {
        super(productDao);
        this.productDao = productDao;
    }
}
