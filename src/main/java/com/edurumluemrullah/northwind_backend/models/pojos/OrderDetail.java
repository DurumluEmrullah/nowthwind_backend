package com.edurumluemrullah.northwind_backend.models.pojos;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@Entity
@Table(name = "order_details")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Positive
    @Column(name = "product_id")
    private int productId;

    @Positive
    @Column(name = "unit_price")
    private double unitPrice;

    @PositiveOrZero
    @Column(name = "quantity")
    private int quantity;

    @PositiveOrZero
    @Column(name = "discount")
    private double discount;
}
