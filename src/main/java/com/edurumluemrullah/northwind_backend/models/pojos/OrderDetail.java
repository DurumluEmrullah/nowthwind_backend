package com.edurumluemrullah.northwind_backend.models.pojos;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column(name = "product_id")
    private int productId;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "discount")
    private double discount;
}
