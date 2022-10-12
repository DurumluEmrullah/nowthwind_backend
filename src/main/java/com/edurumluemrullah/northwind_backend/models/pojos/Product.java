package com.edurumluemrullah.northwind_backend.models.pojos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @NotBlank
    @Size(min = 3)
    @Column(name = "product_name")
    private String productName;

    @Positive
    @Column(name = "supplier_id")
    private int supplierId;

    @Positive
    @Column(name = "category_id")
    private int categoryId;

    @Positive
    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;

    @Positive
    @Column(name = "unit_price")
    private double unitPrice;

    @PositiveOrZero
    @Column(name = "units_in_stock")
    private int unitsInStock;

    @PositiveOrZero
    @Column(name = "units_on_order")
    private int unitsOnOrder;

    @PositiveOrZero
    @Column(name = "reorder_level")
    private int reorderLevel;

    @PositiveOrZero
    @Column(name = "discontinued")
    private int discontinued;
}
