package com.edurumluemrullah.northwind_backend.controllers;

import com.edurumluemrullah.northwind_backend.common.controller.BaseController;
import com.edurumluemrullah.northwind_backend.models.pojos.Territory;
import com.edurumluemrullah.northwind_backend.services.abstracts.TerritoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/territories")
public class TerritoryController extends BaseController<Territory> {

    private final TerritoryService territoryService;

    public TerritoryController(TerritoryService territoryService) {
        super(territoryService);
        this.territoryService = territoryService;
    }
}
