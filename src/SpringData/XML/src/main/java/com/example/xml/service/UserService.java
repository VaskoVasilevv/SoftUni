package com.example.xml.service;

import com.example.xml.model.dto.UserSeedDto;
import com.example.xml.model.dto.UsersViewRootDto;
import com.example.xml.model.entity.User;

import java.util.List;

public interface UserService {
    long getCount();

    void seedUsers(List<UserSeedDto> users);

    User getRandomUser();

    UsersViewRootDto findUsersWithMoreThanOneProduct();
}
