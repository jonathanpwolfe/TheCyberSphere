package com.thecybersphere.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thecybersphere.model.CyberSphereUserDetails;
import com.thecybersphere.model.UserInfo;
import com.thecybersphere.service.LoginService;

@RestController
@RequestMapping(path = "/login", produces = "application/json", consumes = "application/json")
@CrossOrigin("localhost")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<CyberSphereUserDetails> login(@RequestBody UserInfo user) {
        // Assuming UserInfo has getters for username and password
        String username = user.getUsername();
        String password = user.getPassword();

        // Validate and process login
        // Note: You should perform proper validation, authentication, and error handling here

        // For demonstration purposes, let's assume loginService.login returns Optional<UserInfo>
        Optional<CyberSphereUserDetails> userDetailsOptional = loginService.login(username, password);

        // Check if user is found
        if (userDetailsOptional.isPresent()) {
            return ResponseEntity.ok(userDetailsOptional.get());
        } else {
            // User not found, return an appropriate response
            return ResponseEntity.notFound().build();
        }
    }
}
