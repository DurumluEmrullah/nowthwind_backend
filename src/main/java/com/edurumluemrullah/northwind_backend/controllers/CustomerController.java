package com.edurumluemrullah.northwind_backend.controllers;

import com.edurumluemrullah.northwind_backend.common.controller.BaseController;
import com.edurumluemrullah.northwind_backend.models.pojos.Customer;
import com.edurumluemrullah.northwind_backend.services.abstracts.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController extends BaseController<Customer> {

    private final CustomerService customerService;

    public CustomerController( CustomerService customerService) {
        super(customerService);
        this.customerService = customerService;
    }
}
