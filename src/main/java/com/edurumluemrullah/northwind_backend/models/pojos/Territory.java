package com.edurumluemrullah.northwind_backend.models.pojos;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "territories")
public class Territory {

    @Id
    @Column(name = "territory_id")
    private String id;

    @NotBlank
    @Size(min = 5)
    @Column(name = "territory_description")
    private String territoryDescription;

    @Positive
    @Column(name = "region_id")
    private int regionId;
}
