package com.thecybersphere.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force = true)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	@NotNull
	@Size(min=5, max = 22)
	private String username;
	private Date createdAt = new Date();
	private Date lastOnline = new Date();
	
}

