package com.edurumluemrullah.northwind_backend.services.impl;

import com.edurumluemrullah.northwind_backend.auth.JwtTokenProvider;
import com.edurumluemrullah.northwind_backend.common.exceptions.EmailAlreadyExistException;
import com.edurumluemrullah.northwind_backend.common.exceptions.LoginException;
import com.edurumluemrullah.northwind_backend.common.exceptions.UserAlreadyExistException;
import com.edurumluemrullah.northwind_backend.common.exceptions.UserNotFoundException;
import com.edurumluemrullah.northwind_backend.common.results.DataResult;
import com.edurumluemrullah.northwind_backend.common.results.SuccessDataResult;
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
//TODO refactor edilecek !!!
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
        //TODO refactor edilecek !!!
        Optional<User> byUsername = userDao.findByUsername(userRegisterRequestDto.getUsername());

        if(byUsername.isPresent()){
            throw new UserAlreadyExistException(userRegisterRequestDto.getUsername()+" is already exist");
        }

        Optional<User> byEmail = userDao.findByEmail(userRegisterRequestDto.getEmail());

        if(byEmail.isPresent()){
            throw new EmailAlreadyExistException("You are already register with this email : " +userRegisterRequestDto.getEmail());
        }


        // TODO  email validation  ......

        User user = new User();
        user.setUsername(userRegisterRequestDto.getUsername());
        user.setEmail(userRegisterRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRegisterRequestDto.getPassword()));
        HashSet<UserRole> roleSet = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setRole("USER");
        UserRole userRoleIsExist = userRoleService.getByRole("USER");
        if(userRoleIsExist !=null){
            userRole=userRoleIsExist;
        }

        roleSet.add(userRole);
        user.setUserRoleList(roleSet);

        User registeredUser = userDao.save(user);

        UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();

        userLoginResponseDto.setUsername(registeredUser.getUsername());
        userLoginResponseDto.setEmail(registeredUser.getEmail());
        userLoginResponseDto.setToken(jwtTokenProvider.generateToken(registeredUser.getUsername(),registeredUser.getUserRoleList()));




        return new SuccessDataResult<>("kayıt gerçekleşti",userLoginResponseDto);
    }
}
