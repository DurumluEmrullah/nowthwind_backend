package com.edurumluemrullah.northwind_backend.models.pojos;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;

    @NotBlank
    @Size(min = 3)
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Size(min = 3)
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Size(min = 3)
    @Column(name = "title")
    private String title;

    @NotBlank
    @Size(min = 3)
    @Column(name = "title_of_courtesy")
    private String titleOfCourtesy;

    @NotBlank
    @Size(min = 3)
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "hire_date")
    private Date hireDate;

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
    @Pattern(message = "Enter a  valid postal code", regexp = "^(?:[+-]?(\\d+)([,.]\\d+)?)?$")
    @Column(name = "postal_code")
    private String postalCode;

    @NotBlank
    @Size(min = 3)
    @Column(name = "country")
    private String country;

    @NotBlank
    @Pattern(message = "Enter a valid phone number" ,regexp = "\\\\d{10}|(?:\\\\d{3}-){2}\\\\d{4}|\\\\(\\\\d{3}\\\\)\\\\d{3}-?\\\\d{4}")
    @Column(name = "home_phone")
    private String homePhone;

    @NotBlank
    @Size(min = 3)
    @Column(name = "extension")
    private String extension;


    @Column(name = "photo")
    private String photo;

    @NotBlank
    @Size(min = 3)
    @Column(name = "notes")
    private String notes;
}
