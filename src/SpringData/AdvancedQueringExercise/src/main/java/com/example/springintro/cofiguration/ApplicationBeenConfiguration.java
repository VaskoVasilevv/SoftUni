package com.example.springintro.cofiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class ApplicationBeenConfiguration {

    @Bean
    public BufferedReader reader (){
        return new BufferedReader(new InputStreamReader(System.in));
    }
}
