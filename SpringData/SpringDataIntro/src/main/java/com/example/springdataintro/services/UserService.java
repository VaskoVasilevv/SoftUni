package com.example.springdataintro.services;

import java.math.BigDecimal;

public interface UserService {

    void register(String username, int age,BigDecimal initialAmount) throws IllegalAccessException;

    void addAccount(BigDecimal amount,Long id);
}
