package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.common.exceptions.NoAttemptException;
import com.edurumluemrullah.northwind_backend.common.exceptions.VerificationCodeExpiredException;
import com.edurumluemrullah.northwind_backend.common.exceptions.VerificationCodeNotFoundException;
import com.edurumluemrullah.northwind_backend.common.exceptions.WrongVerifcationCodeException;
import com.edurumluemrullah.northwind_backend.common.results.DataResult;
import com.edurumluemrullah.northwind_backend.common.results.Result;
import com.edurumluemrullah.northwind_backend.common.results.SuccessResult;
import com.edurumluemrullah.northwind_backend.models.dtos.VerifyEmailRequestDto;
import com.edurumluemrullah.northwind_backend.models.pojos.User;
import com.edurumluemrullah.northwind_backend.models.pojos.VerificationCode;
import com.edurumluemrullah.northwind_backend.services.abstracts.EmailService;
import com.edurumluemrullah.northwind_backend.services.abstracts.UserService;
import com.edurumluemrullah.northwind_backend.services.abstracts.VerificationCodeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    private final VerificationCodeService verificationCodeService;

    private final UserService userService;

    @Value("${attempt.count}")
    private int attemptCount;

    @Value("${verification.code.expired.time}")
    private int verificationCodeExpiredTime;

    public EmailServiceImpl(JavaMailSender javaMailSender, VerificationCodeService verificationCodeService, UserService userService) {
        this.javaMailSender = javaMailSender;
        this.verificationCodeService = verificationCodeService;
        this.userService = userService;
    }

    @Override
    public Result sendVerificationCode(String email) {

        DataResult<User> userByEmail = userService.getUserByEmail(email);


        int min = 100000;
        int max = 999999;
        int verificationCode = (int)Math.floor(Math.random()*(max-min+1)+min);

        SimpleMailMessage mailMessage
                = new SimpleMailMessage();

        mailMessage.setTo(email);
        mailMessage.setSubject("Northwind_backend Verification Code");


        mailMessage.setText("Your verification code : \n "+verificationCode);


        javaMailSender.send(mailMessage);// TODO MailException handle


        VerificationCode verificationCodeObject = new VerificationCode();



        verificationCodeObject.setVerificationCode(String.valueOf(verificationCode));
        verificationCodeObject.setAttemptCount(attemptCount);
        verificationCodeObject.setExpiredDate(new Date(System.currentTimeMillis()+verificationCodeExpiredTime));
        verificationCodeObject.setUserId(userByEmail.getData().getId());


        verificationCodeService.create(verificationCodeObject);

        return new SuccessResult("Email sent successfully");
    }

    @Override
    public Result verifyEmail(VerifyEmailRequestDto verifyEmailRequestDto) {
        DataResult<User> userByEmail = userService.getUserByEmail(verifyEmailRequestDto.getEmail());

        User user = userByEmail.getData();

        DataResult<VerificationCode> verificationCodeDataResult = verificationCodeService.getByUserId(user.getId());

        VerificationCode verificationCode = verificationCodeDataResult.getData();

        if(!verificationCodeDataResult.isSuccess()){
            throw new VerificationCodeNotFoundException("Verification code not found");
        }

        if(verificationCode.getAttemptCount()==0){
            verificationCodeService.delete(verificationCode);
            throw new NoAttemptException("Incorrect verification code entered 5 times , get a new verification code");
        }

        if(verificationCode.getExpiredDate().before(new Date(System.currentTimeMillis()))){
            verificationCodeService.delete(verificationCode);
            throw new VerificationCodeExpiredException("Verification code expired, get a new verification code");
        }


        if(!verificationCode.getVerificationCode().equals(verifyEmailRequestDto.getVerifyCode())){
           verificationCode.setAttemptCount(verificationCode.getAttemptCount()-1);
           verificationCodeService.update(verificationCode);
           throw new WrongVerifcationCodeException("entered verification code is wrong");
        }

        verificationCodeService.delete(verificationCode);
        user.setValidated(true);
        userService.updateUser(user);



        return new SuccessResult("Verified email ");
    }
}
