package com.edurumluemrullah.northwind_backend.models.pojos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Positive
    @Column(name = "customer_id")
    private String customerId;

    @Positive
    @Column(name = "employee_id")
    private int employeeId;


    @Column(name = "order_date")
    private Date orderDate;

    @NotNull
    @Column(name = "required_date")
    private Date requiredDate;

    @NotNull
    @Column(name = "shipped_date")
    private Date shippedDate;

    @PositiveOrZero
    @Column(name = "ship_via")
    private int shipVia;

    @PositiveOrZero
    @Column(name = "freight")
    private double freight;

    @NotBlank
    @Size(min = 3)
    @Column(name = "ship_name")
    private String shipName;

    @NotBlank
    @Size(min = 3)
    @Column(name = "ship_address")
    private String shipAddress;

    @NotBlank
    @Size(min = 3)
    @Column(name = "ship_city")
    private String shipCity;

    @NotBlank
    @Size(min = 3)
    @Column(name = "ship_region")
    private String shipRegion;

    @NotBlank
    @Pattern(message = "Enter a  valid postal code", regexp = "^(?:[+-]?(\\d+)([,.]\\d+)?)?$")
    @Column(name = "ship_postal_code")
    private String shipPostalCode;

    @NotBlank
    @Size(min = 3)
    @Column(name = "ship_country")
    private String shipCountry;
}
