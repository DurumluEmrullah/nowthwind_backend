package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.common.services.impl.BaseServiceImpl;
import com.edurumluemrullah.northwind_backend.daos.ShipperDao;
import com.edurumluemrullah.northwind_backend.models.pojos.Shipper;
import com.edurumluemrullah.northwind_backend.services.abstracts.ShipperService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ShipperServiceImpl extends BaseServiceImpl<Shipper> implements ShipperService {

    private final ShipperDao shipperDao;

    public ShipperServiceImpl(ShipperDao shipperDao) {
        super(shipperDao);
        this.shipperDao = shipperDao;
    }
}
