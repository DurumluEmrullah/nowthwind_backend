package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.common.exceptions.AlreadyHaveVerificationCodeException;
import com.edurumluemrullah.northwind_backend.common.results.*;
import com.edurumluemrullah.northwind_backend.daos.VerificationCodeDao;
import com.edurumluemrullah.northwind_backend.models.pojos.VerificationCode;
import com.edurumluemrullah.northwind_backend.services.abstracts.VerificationCodeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {


    private final VerificationCodeDao verificationCodeDao;



    public VerificationCodeServiceImpl(VerificationCodeDao verificationCodeDao) {
        this.verificationCodeDao = verificationCodeDao;
    }

    @Override
    public Result create(VerificationCode verificationCode) {

        DataResult<VerificationCode> byUserId = getByUserId(verificationCode.getUserId());

        if(byUserId.isSuccess()){
            throw new AlreadyHaveVerificationCodeException("you have already verification code");
        }

        verificationCodeDao.save(verificationCode);

        return new SuccessResult("created");
    }

    @Override
    public Result update(VerificationCode verificationCode) {
        verificationCodeDao.save(verificationCode);

        return new SuccessResult("updated");
    }

    @Override
    public DataResult<VerificationCode> getByUserId(int userId) {
        Optional<VerificationCode> byUserId = verificationCodeDao.findByUserId(userId);

        DataResult<VerificationCode> result = new ErrorDataResult<>("no such verification code",null);

        if(byUserId.isPresent()){
            result = new SuccessDataResult<>("found",byUserId.get());
        }

        return result;
    }

    @Override
    public Result delete(VerificationCode verificationCode) {
        verificationCodeDao.delete(verificationCode);
        return new SuccessResult("deleted");
    }
}
