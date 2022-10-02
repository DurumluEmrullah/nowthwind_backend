package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.common.results.DataResult;
import com.edurumluemrullah.northwind_backend.common.services.impl.BaseServiceImpl;
import com.edurumluemrullah.northwind_backend.daos.CustomerDao;
import com.edurumluemrullah.northwind_backend.models.pojos.Customer;
import com.edurumluemrullah.northwind_backend.services.abstracts.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {

    private final CustomerDao customerDao;

    public CustomerServiceImpl( CustomerDao customerDao) {
        super(customerDao);
        this.customerDao = customerDao;
    }

    @Override
    public DataResult<Customer> create(Customer entity) {
        return super.create(entity);
    }
}
