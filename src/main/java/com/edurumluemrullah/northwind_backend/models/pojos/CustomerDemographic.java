package com.edurumluemrullah.northwind_backend.models.pojos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "customer_demographics")
public class CustomerDemographic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private int id;

    @NotBlank
    @Size(min = 7)
    @Column(name = "customer_desc")
    private String customerDesc;

}
