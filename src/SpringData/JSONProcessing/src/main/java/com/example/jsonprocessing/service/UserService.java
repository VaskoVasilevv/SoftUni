package com.example.jsonprocessing.service;

import com.example.jsonprocessing.model.dto.UserSoldDto;
import com.example.jsonprocessing.model.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    void seedUser() throws IOException;

    User findRandomUser();

    List<UserSoldDto> findAllUsersWithMoreThanOneSoldProducts();
}
