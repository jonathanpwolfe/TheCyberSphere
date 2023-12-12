package com.thecybersphere.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.thecybersphere.repo.LoginRepository;

public class LoginService {

    @Autowired
    private LoginRepository loginRepo;

    // You might want to replace "UserInfo" with the actual type you are using
    void login(String username, String password) {
        loginRepo.findByUsername(username)
            .ifPresentOrElse(
                userInfo -> {
                    if( userInfo.getPassword() == password)
                    System.out.println("Login successful for user: " + username);
                },
                () -> {
                    // Logic for unsuccessful login (user not found)
                    System.out.println("Login failed for user: " + username);
                }
            );
    }
}
