package com.edurumluemrullah.northwind_backend.controllers;

import com.edurumluemrullah.northwind_backend.common.controller.BaseController;
import com.edurumluemrullah.northwind_backend.common.services.abstracts.BaseService;
import com.edurumluemrullah.northwind_backend.models.pojos.Product;
import com.edurumluemrullah.northwind_backend.services.abstracts.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController extends BaseController<Product> {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        super(productService);
        this.productService = productService;
    }
}
