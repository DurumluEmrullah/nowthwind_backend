package com.edurumluemrullah.northwind_backend.models.pojos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "region")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id")
    private int id;

    @NotBlank
    @Size(min = 10)
    @Column(name = "region_description")
    private String regionDescription;
}
