package com.edurumluemrullah.northwind_backend.models.pojos;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "shippers")
public class Shipper {

    @Id
    @Column(name = "shipper_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min = 3,max = 40)
    @Column(name = "company_name")
    private String companyName;


    @NotBlank

    @Column(name = "phone")
    private String phone;
}
