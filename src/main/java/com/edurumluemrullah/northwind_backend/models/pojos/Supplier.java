package com.edurumluemrullah.northwind_backend.models.pojos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private int id;

    @NotBlank
    @Size(min = 3)
    @Column(name = "company_name")
    private String companyName;

    @NotBlank
    @Size(min = 3)
    @Column(name = "contact_name")
    private String contractName;

    @NotBlank
    @Size(min = 3)
    @Column(name = "contact_title")
    private String contactTitle;

    @NotBlank
    @Size(min = 3)
    @Column(name = "address")
    private String address;

    @NotBlank
    @Size(min = 3)
    @Column(name = "city")
    private String city;

    @NotBlank
    @Size(min = 3)
    @Column(name = "region")
    private String region;

    @NotBlank
    @Pattern(message = "Enter a  valid postal coder", regexp = "^(?:[+-]?(\\d+)([,.]\\d+)?)?$")
    @Size(min = 3,max = 6)
    @Column(name = "postal_code")
    private String postalCode;

    @NotBlank
    @Size(min = 3)
    @Column(name = "country")
    private String country;

    @NotBlank
    @Pattern(message = "Enter a valid phone number" ,regexp = "\\\\d{10}|(?:\\\\d{3}-){2}\\\\d{4}|\\\\(\\\\d{3}\\\\)\\\\d{3}-?\\\\d{4}")
    @Column(name = "phone")
    private String phone;

    @NotBlank
    @Column(name = "fax")
    private String fax;

    @NotBlank
    @Column(name = "homepage")
    private String homepage;


}
