package com.edurumluemrullah.northwind_backend.models.pojos;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer_demographics")
public class CustomerDemographic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private int id;

    @Column(name = "customer_desc")
    private String customerDesc;

}
