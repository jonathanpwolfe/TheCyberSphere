package com.thecybersphere.model;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;

public class MyUserDetails implements UserDetails {

  
	private static final long serialVersionUID = -8665926158027740173L;

	private final CyberSphereUser user; // Replace with your actual user entity
	

	
    public MyUserDetails(CyberSphereUser user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Implement logic to return the user's authorities (roles)
        // Example: return user.getRoles();
        return null; // Replace with your actual implementation
    }

    @Override
    public String getPassword() {
        // Implement logic to return the user's password
        // Example: return user.getPassword();
        return null; // Replace with your actual implementation
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

    // Implement other UserDetails methods...

    // Customize the methods based on your user entity structure
}
