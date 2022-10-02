package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.common.services.impl.BaseServiceImpl;
import com.edurumluemrullah.northwind_backend.daos.OrderDetailDao;
import com.edurumluemrullah.northwind_backend.models.pojos.OrderDetail;
import com.edurumluemrullah.northwind_backend.services.abstracts.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail> implements OrderDetailService {

    private final OrderDetailDao detailDao;

    @Autowired
    public OrderDetailServiceImpl(OrderDetailDao detailDao) {
        super(detailDao);
        this.detailDao = detailDao;
    }
}
