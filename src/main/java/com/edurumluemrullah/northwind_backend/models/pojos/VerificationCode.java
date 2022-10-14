package com.edurumluemrullah.northwind_backend.models.pojos;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "verification_codes")
@Entity
public class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "verification_code")
    private String verificationCode;

    @Column(name = "expired_date")
    private Date expiredDate;

    @Column(name = "attempt_count")
    private int attemptCount;

}
