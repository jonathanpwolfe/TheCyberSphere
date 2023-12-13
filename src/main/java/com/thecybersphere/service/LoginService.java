package com.thecybersphere.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thecybersphere.model.CyberSphereUser;
import com.thecybersphere.model.CyberSphereUserDetails;
import com.thecybersphere.model.UserInfo;
import com.thecybersphere.repo.LoginRepository;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepo;

    public Optional<CyberSphereUserDetails> login(String username, String password) {
        Optional<CyberSphereUserDetails> userDetailsOptional = loginRepo.findByUsername(username);

        if (userDetailsOptional.isPresent()) {
        	CyberSphereUserDetails userDetails = userDetailsOptional.get();

            // Use equals for string comparison
            if (userDetails.getPassword().equals(password)) {
                System.out.println("Login successful for user: " + username);
                return Optional.of(userDetails);
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
