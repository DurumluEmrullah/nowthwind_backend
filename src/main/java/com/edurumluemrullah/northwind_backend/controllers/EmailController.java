package com.edurumluemrullah.northwind_backend.controllers;

import com.edurumluemrullah.northwind_backend.models.dtos.VerifyEmailRequestDto;
import com.edurumluemrullah.northwind_backend.services.abstracts.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyEmail(@RequestBody VerifyEmailRequestDto verifyEmailRequestDto){
        return ResponseEntity.ok(emailService.verifyEmail(verifyEmailRequestDto));
    }

    @PostMapping("/sendVerificationCode")
    public ResponseEntity<?> sendVerificationCode(@RequestParam("email") String email){
        return ResponseEntity.ok(emailService.sendVerificationCode(email));
    }
}
