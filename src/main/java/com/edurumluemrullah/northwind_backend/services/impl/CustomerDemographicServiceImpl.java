package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.common.results.DataResult;
import com.edurumluemrullah.northwind_backend.common.services.impl.BaseServiceImpl;
import com.edurumluemrullah.northwind_backend.daos.CustomerDemographicDao;
import com.edurumluemrullah.northwind_backend.models.pojos.CustomerDemographic;
import com.edurumluemrullah.northwind_backend.services.abstracts.CustomerDemographicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDemographicServiceImpl extends BaseServiceImpl<CustomerDemographic> implements CustomerDemographicService {

    private final CustomerDemographicDao customerDemographicDao;

    @Autowired
    public CustomerDemographicServiceImpl(CustomerDemographicDao customerDemographicDao) {
        super(customerDemographicDao);
        this.customerDemographicDao=customerDemographicDao;
    }

    @Override
    public DataResult<CustomerDemographic> create(CustomerDemographic entity) {
        entity.setId(0);
        return super.create(entity);
    }
}
