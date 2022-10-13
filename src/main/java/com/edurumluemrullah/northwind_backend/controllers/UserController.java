package com.edurumluemrullah.northwind_backend.controllers;


import com.edurumluemrullah.northwind_backend.models.dtos.UserLoginRequestDto;
import com.edurumluemrullah.northwind_backend.services.abstracts.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequestDto userLoginRequestDto){

        return ResponseEntity.ok(userService.login(userLoginRequestDto));

    }

    @GetMapping("/register")
    public String signup(){
        return "merhaba";
    }
}
