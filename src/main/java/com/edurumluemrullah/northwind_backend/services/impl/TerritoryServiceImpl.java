package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.common.services.impl.BaseServiceImpl;
import com.edurumluemrullah.northwind_backend.daos.TerritoryDao;
import com.edurumluemrullah.northwind_backend.models.pojos.Territory;
import com.edurumluemrullah.northwind_backend.services.abstracts.TerritoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerritoryServiceImpl extends BaseServiceImpl<Territory> implements TerritoryService {

    private final TerritoryDao territoryDao;

    @Autowired
    public TerritoryServiceImpl(TerritoryDao territoryDao) {
        super(territoryDao);
        this.territoryDao = territoryDao;
    }
}
