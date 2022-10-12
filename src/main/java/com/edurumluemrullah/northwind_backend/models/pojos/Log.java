package com.edurumluemrullah.northwind_backend.models.pojos;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
@Table(name = "logs")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "message")
    private String message;

    @Column(name = "parameters")
    private String parameter;

    @Column(name = "method_name")
    private String method;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private boolean status;

}
