package com.edurumluemrullah.northwind_backend.controllers;


import com.edurumluemrullah.northwind_backend.common.controller.BaseController;
import com.edurumluemrullah.northwind_backend.models.pojos.OrderDetail;
import com.edurumluemrullah.northwind_backend.services.abstracts.OrderDetailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailController extends BaseController<OrderDetail> {

    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailService orderDetailService) {
        super(orderDetailService);
        this.orderDetailService = orderDetailService;
    }
}
