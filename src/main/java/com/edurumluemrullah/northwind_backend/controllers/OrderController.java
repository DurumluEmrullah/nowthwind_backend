package com.edurumluemrullah.northwind_backend.controllers;

import com.edurumluemrullah.northwind_backend.common.controller.BaseController;
import com.edurumluemrullah.northwind_backend.common.services.abstracts.BaseService;
import com.edurumluemrullah.northwind_backend.models.pojos.Order;
import com.edurumluemrullah.northwind_backend.services.abstracts.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController<Order> {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        super(orderService);
        this.orderService=orderService;
    }
}
