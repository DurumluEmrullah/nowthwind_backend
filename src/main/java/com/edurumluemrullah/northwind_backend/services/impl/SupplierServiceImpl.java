package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.common.services.impl.BaseServiceImpl;
import com.edurumluemrullah.northwind_backend.daos.SupplierDao;
import com.edurumluemrullah.northwind_backend.models.pojos.Supplier;
import com.edurumluemrullah.northwind_backend.services.abstracts.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl extends BaseServiceImpl<Supplier> implements SupplierService {

    private final SupplierDao supplierDao;

    @Autowired
    public SupplierServiceImpl( SupplierDao supplierDao) {
        super(supplierDao);
        this.supplierDao = supplierDao;
    }
}
