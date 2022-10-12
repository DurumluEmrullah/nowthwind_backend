package com.edurumluemrullah.northwind_backend.models.pojos;


import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @NotBlank
    @Size(min = 3)
    @Column(name = "category_name")
    private String categoryName;

    @NotBlank
    @Size(min=10)
    @Column(name = "description")
    private String description;




}
