package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.auth.JwtTokenProvider;
import com.edurumluemrullah.northwind_backend.common.exceptions.*;
import com.edurumluemrullah.northwind_backend.common.results.DataResult;
import com.edurumluemrullah.northwind_backend.common.results.Result;
import com.edurumluemrullah.northwind_backend.common.results.SuccessDataResult;
import com.edurumluemrullah.northwind_backend.common.results.SuccessResult;
import com.edurumluemrullah.northwind_backend.daos.UserDao;
import com.edurumluemrullah.northwind_backend.models.dtos.UserLoginRequestDto;
import com.edurumluemrullah.northwind_backend.models.dtos.UserLoginResponseDto;
import com.edurumluemrullah.northwind_backend.models.dtos.UserRegisterRequestDto;
import com.edurumluemrullah.northwind_backend.models.pojos.User;
import com.edurumluemrullah.northwind_backend.models.pojos.UserRole;
import com.edurumluemrullah.northwind_backend.services.abstracts.UserRoleService;
import com.edurumluemrullah.northwind_backend.services.abstracts.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRoleService userRoleService;


    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, UserRoleService userRoleService) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRoleService = userRoleService;
    }


    @Override
    public DataResult<UserLoginResponseDto> login(UserLoginRequestDto userLoginRequestDto) {

        Optional<User> user = userDao.findByUsername(userLoginRequestDto.getUsername());

        if(!user.isPresent()){
            throw new UserNotFoundException("User '" + userLoginRequestDto.getUsername() + "' not found");
        }

        if(!passwordEncoder.matches(userLoginRequestDto.getPassword(),user.get().getPassword())  ){
            throw new LoginException("wrong password");
        }

        if(!user.get().isValidated()){
            throw new EmailNotValidatedException("This email isn't validated");
        }

        UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();
        userLoginResponseDto.setUsername(user.get().getUsername());
        userLoginResponseDto.setEmail(user.get().getEmail());
        userLoginResponseDto.setToken(jwtTokenProvider.generateToken(user.get().getUsername(),user.get().getUserRoleList()));


        return new SuccessDataResult<>("success",userLoginResponseDto);
    }

    @Override
    public Result register(UserRegisterRequestDto userRegisterRequestDto) {
        //TODO refactor edilecek !!!
        Optional<User> byUsername = userDao.findByUsername(userRegisterRequestDto.getUsername());

        if(byUsername.isPresent()){
            throw new UserAlreadyExistException(userRegisterRequestDto.getUsername()+" is already exist");
        }

        Optional<User> byEmail = userDao.findByEmail(userRegisterRequestDto.getEmail());

        if(byEmail.isPresent()){
            throw new EmailAlreadyExistException("You are already register with this email : " +userRegisterRequestDto.getEmail());
        }



        User user = new User();
        user.setUsername(userRegisterRequestDto.getUsername());
        user.setEmail(userRegisterRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterRequestDto.getPassword()));
        HashSet<UserRole> roleSet = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setRole("USER");
        UserRole userRoleIsExist = userRoleService.getByRole("USER");
        user.setValidated(false);
        if(userRoleIsExist !=null){
            userRole=userRoleIsExist;
        }

        roleSet.add(userRole);
        user.setUserRoleList(roleSet);

        userDao.save(user);


        return new SuccessResult("registered user");
    }

    @Override
    public DataResult<User> getUserByEmail(String email) {
        Optional<User> byEmail = userDao.findByEmail(email);

        if(!byEmail.isPresent()){
            throw new EmailNotFoundException("Email not found");// TODO
        }

        return new SuccessDataResult<>("User found",byEmail.get()) ;
    }

    @Override
    public DataResult<User> updateUser(User user) {
        return new SuccessDataResult<>("updated user",userDao.save(user));
    }
}
