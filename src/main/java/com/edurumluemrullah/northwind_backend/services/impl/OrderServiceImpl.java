package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.common.results.DataResult;
import com.edurumluemrullah.northwind_backend.common.services.impl.BaseServiceImpl;
import com.edurumluemrullah.northwind_backend.daos.OrderDao;
import com.edurumluemrullah.northwind_backend.models.pojos.Order;
import com.edurumluemrullah.northwind_backend.services.abstracts.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {

    private final OrderDao orderDao;

    @Autowired
    public OrderServiceImpl( OrderDao orderDao) {
        super(orderDao);
        this.orderDao = orderDao;
    }

    @Override
    public DataResult<Order> create(Order entity) {
        entity.setId(0);
        return super.create(entity);
    }
}
