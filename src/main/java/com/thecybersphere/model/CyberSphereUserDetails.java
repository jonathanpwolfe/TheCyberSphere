package com.thecybersphere.model;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.UUID;

@Data
@Entity
@Table(name = "user_details")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CyberSphereUserDetails implements UserDetails {

  
	private static final long serialVersionUID = -8665926158027740173L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID uuid;
	
	@NotNull
	@Size(min=5, max = 22)
	private String username;
	@NotNull
	@Size(min=5, max = 22)
	private String password;
	
	@OneToOne
	private  CyberSphereUser cyberSphereUser;
	
   

    public CyberSphereUserDetails(String username, String password) {
		this.username = username;
		this.password = password;
	}
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Implement logic to return the user's authorities (roles)
        // Example: return user.getRoles();
        return null; // Replace with your actual implementation
    }
    void setPassword(String string) {
    	this.password = string; 
    }
    @Override
    public String getPassword() {
        // Implement logic to return the user's password
        // Example: return user.getPassword();
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
	public void setUsername(String string) {
		this.username=string;
	}

    // Implement other UserDetails methods...

    // Customize the methods based on your user entity structure
}
