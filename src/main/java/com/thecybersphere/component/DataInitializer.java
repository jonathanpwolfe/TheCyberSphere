package com.thecybersphere.component;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.thecybersphere.model.CyberSphereUser;
import com.thecybersphere.repo.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Initialize sample data
    	Collection<SimpleGrantedAuthority> authorities = Arrays.asList(
                new SimpleGrantedAuthority("ROLE_USER"),
                new SimpleGrantedAuthority("ROLE_ADMIN")
        );
        CyberSphereUser user1 = new CyberSphereUser("john_doe","password123", authorities);

        CyberSphereUser user2 = new CyberSphereUser("jane_doe", "secure_password", authorities);

        // Save to the database
        userRepository.save(user1);
        userRepository.save(user2);
    }
}