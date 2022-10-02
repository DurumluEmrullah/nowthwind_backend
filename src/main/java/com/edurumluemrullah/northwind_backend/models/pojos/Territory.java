package com.edurumluemrullah.northwind_backend.models.pojos;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "territories")
public class Territory {

    @Id
    @Column(name = "territory_id")
    private String id;

    @Column(name = "territory_description")
    private String territoryDescription;

    @Column(name = "region_id")
    private int regionId;
}
