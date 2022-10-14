package com.edurumluemrullah.northwind_backend.services.abstracts;

import com.edurumluemrullah.northwind_backend.common.results.DataResult;
import com.edurumluemrullah.northwind_backend.models.dtos.UserLoginRequestDto;
import com.edurumluemrullah.northwind_backend.models.dtos.UserLoginResponseDto;
import com.edurumluemrullah.northwind_backend.models.dtos.UserRegisterRequestDto;
import com.edurumluemrullah.northwind_backend.models.pojos.User;

public interface UserService {

    DataResult<UserLoginResponseDto> login (UserLoginRequestDto userLoginRequestDto);

    DataResult<User> register(UserRegisterRequestDto userRegisterRequestDto);

    DataResult<User> getUserByEmail(String email);

    DataResult<User> updateUser(User user);
}
