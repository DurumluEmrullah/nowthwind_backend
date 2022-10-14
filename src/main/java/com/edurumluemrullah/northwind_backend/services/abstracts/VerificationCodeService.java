package com.edurumluemrullah.northwind_backend.services.abstracts;

import com.edurumluemrullah.northwind_backend.common.results.DataResult;
import com.edurumluemrullah.northwind_backend.common.results.Result;
import com.edurumluemrullah.northwind_backend.models.pojos.VerificationCode;

public interface VerificationCodeService {

    Result create(VerificationCode verificationCode);

    Result update(VerificationCode verificationCode);

    DataResult<VerificationCode> getByUserId(int userId);

    Result delete(VerificationCode verificationCode);

}
