package com.edurumluemrullah.northwind_backend.models.pojos;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "supplier_id")
    private int supplierId;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "quantity_per_unit")
    private int quantityPerUnit;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "units_on_order")
    private int unitsOnOrder;

    @Column(name = "reorder_level")
    private int reorderLevel;

    @Column(name = "discontinued")
    private int discontinued;
}
