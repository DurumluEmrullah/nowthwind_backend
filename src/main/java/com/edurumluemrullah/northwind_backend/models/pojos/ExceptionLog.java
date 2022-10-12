package com.edurumluemrullah.northwind_backend.models.pojos;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "exceptions")
public class ExceptionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "log_id")
    private int logId;

    @Column(name = "exception_type_id")
    private int exceptionTypeId;

    @Column(name = "message")
    private String exceptionMessage;

    @Column(name = "stack_trace")
    private String stackTrace;
}
