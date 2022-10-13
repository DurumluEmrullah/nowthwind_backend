package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.auth.JwtTokenProvider;
import com.edurumluemrullah.northwind_backend.common.exceptions.LoginException;
import com.edurumluemrullah.northwind_backend.common.exceptions.UserNotFoundException;
import com.edurumluemrullah.northwind_backend.common.results.DataResult;
import com.edurumluemrullah.northwind_backend.common.results.SuccessDataResult;
import com.edurumluemrullah.northwind_backend.daos.UserDao;
import com.edurumluemrullah.northwind_backend.models.dtos.UserLoginRequestDto;
import com.edurumluemrullah.northwind_backend.models.dtos.UserLoginResponseDto;
import com.edurumluemrullah.northwind_backend.models.dtos.UserRegisterRequestDto;
import com.edurumluemrullah.northwind_backend.models.pojos.User;
import com.edurumluemrullah.northwind_backend.services.abstracts.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @Override
    public DataResult<UserLoginResponseDto> login(UserLoginRequestDto userLoginRequestDto) {

        Optional<User> user = userDao.findByUsername(userLoginRequestDto.getUsername());
        String test123 = passwordEncoder.encode("test123");
        if(!user.isPresent()){
            throw new UserNotFoundException("User '" + userLoginRequestDto.getUsername() + "' not found");
        }
     //   user.get().getPassword().equals(passwordEncoder.encode(userLoginRequestDto.getPassword()))
        if(!passwordEncoder.matches(userLoginRequestDto.getPassword(),user.get().getPassword())  ){
            throw new LoginException("wrong password");
        }

        UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();
        userLoginResponseDto.setUsername(user.get().getUsername());
        userLoginResponseDto.setEmail(user.get().getEmail());
        userLoginResponseDto.setToken(jwtTokenProvider.generateToken(user.get().getUsername(),user.get().getUserRoleList()));
//değiştir

        return new SuccessDataResult<>("success",userLoginResponseDto);
    }

    @Override
    public DataResult<UserLoginResponseDto> register(UserRegisterRequestDto userRegisterRequestDto) {
        return null;
    }
}
