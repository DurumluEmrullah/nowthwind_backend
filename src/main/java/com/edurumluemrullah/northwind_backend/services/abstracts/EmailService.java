package com.edurumluemrullah.northwind_backend.services.abstracts;

import com.edurumluemrullah.northwind_backend.common.results.Result;
import com.edurumluemrullah.northwind_backend.models.dtos.VerifyEmailRequestDto;

public interface EmailService {

    Result sendVerificationCode(String email);

    Result verifyEmail(VerifyEmailRequestDto verifyEmailRequestDto);
}
