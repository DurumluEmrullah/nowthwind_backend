package com.edurumluemrullah.northwind_backend.controllers;

import com.edurumluemrullah.northwind_backend.common.controller.BaseController;
import com.edurumluemrullah.northwind_backend.models.pojos.CustomerDemographic;
import com.edurumluemrullah.northwind_backend.services.abstracts.CustomerDemographicService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerDemographics")
public class CustomerDemographicController extends BaseController<CustomerDemographic> {

    private final CustomerDemographicService customerDemographicService;

    public CustomerDemographicController(CustomerDemographicService customerDemographicService) {
        super(customerDemographicService);
        this.customerDemographicService=customerDemographicService;
    }
}
