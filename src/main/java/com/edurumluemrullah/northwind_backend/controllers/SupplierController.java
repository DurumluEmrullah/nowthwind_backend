package com.edurumluemrullah.northwind_backend.controllers;

import com.edurumluemrullah.northwind_backend.common.controller.BaseController;
import com.edurumluemrullah.northwind_backend.common.services.abstracts.BaseService;
import com.edurumluemrullah.northwind_backend.models.pojos.Supplier;
import com.edurumluemrullah.northwind_backend.services.abstracts.SupplierService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/suppliers")
public class SupplierController extends BaseController<Supplier> {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        super(supplierService);
        this.supplierService = supplierService;
    }
}
