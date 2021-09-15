package com.example.homework.service;

import com.example.homework.model.dto.UserLoginDto;
import com.example.homework.model.dto.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();

    boolean hasLoggedInUser();
}
