package com.featurevote.service;


import org.hamcrest.CoreMatchers;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.not;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



public class UserDetailServiceTest {
    @Test
    public void test(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String rawPassword = "password123";
        String encodePassword = encoder.encode(rawPassword);

        System.out.println(encodePassword);

        assertThat(rawPassword, not(encodePassword));
    }
}
