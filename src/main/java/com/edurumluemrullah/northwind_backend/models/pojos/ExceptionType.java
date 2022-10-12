package com.edurumluemrullah.northwind_backend.models.pojos;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exception_types")
public class ExceptionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
}
