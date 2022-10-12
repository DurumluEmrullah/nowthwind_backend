package com.edurumluemrullah.northwind_backend.controllers;

import com.edurumluemrullah.northwind_backend.common.controller.BaseController;
import com.edurumluemrullah.northwind_backend.common.services.abstracts.BaseService;
import com.edurumluemrullah.northwind_backend.models.pojos.Shipper;
import com.edurumluemrullah.northwind_backend.services.abstracts.ShipperService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shippers")
public class ShipperController extends BaseController<Shipper> {

    private final ShipperService shipperService;

    public ShipperController(ShipperService shipperService) {
        super(shipperService);
        this.shipperService = shipperService;
    }
}
