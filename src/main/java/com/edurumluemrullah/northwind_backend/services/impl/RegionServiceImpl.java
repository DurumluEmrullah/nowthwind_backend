package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.common.services.impl.BaseServiceImpl;
import com.edurumluemrullah.northwind_backend.daos.RegionDao;
import com.edurumluemrullah.northwind_backend.models.pojos.Region;
import com.edurumluemrullah.northwind_backend.services.abstracts.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionServiceImpl extends BaseServiceImpl<Region> implements RegionService {

    private final RegionDao regionDao;

    @Autowired
    public RegionServiceImpl(RegionDao regionDao) {
        super(regionDao);
        this.regionDao = regionDao;
    }
}
