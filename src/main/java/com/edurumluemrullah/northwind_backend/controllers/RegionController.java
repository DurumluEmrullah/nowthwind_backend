package com.edurumluemrullah.northwind_backend.controllers;

import com.edurumluemrullah.northwind_backend.common.controller.BaseController;
import com.edurumluemrullah.northwind_backend.common.services.abstracts.BaseService;
import com.edurumluemrullah.northwind_backend.models.pojos.Region;
import com.edurumluemrullah.northwind_backend.services.abstracts.RegionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regions")
public class RegionController extends BaseController<Region> {

    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        super(regionService);
        this.regionService = regionService;
    }
}
