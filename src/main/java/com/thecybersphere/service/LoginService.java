package com.thecybersphere.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thecybersphere.model.UserInfo;
import com.thecybersphere.repo.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepo;

    public Optional<UserInfo> login(String username, String password) {
        Optional<UserInfo> userInfoOptional = loginRepo.findByUsername(username);

        if (userInfoOptional.isPresent()) {
            UserInfo userInfo = userInfoOptional.get();

            // Use equals for string comparison
            if (userInfo.getPassword().equals(password)) {
                System.out.println("Login successful for user: " + username);
                return Optional.of(userInfo);
            } else {
                System.out.println("Login failed for user: " + username + " (Incorrect password)");
            }
        } else {
            // Logic for unsuccessful login (user not found)
            System.out.println("Login failed for user: " + username + " (User not found)");
        }

        return Optional.empty();
    }
}
