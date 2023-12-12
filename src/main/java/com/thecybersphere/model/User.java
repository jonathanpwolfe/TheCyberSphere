package com.thecybersphere.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "app_user")
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force = true)
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@NotNull
	@Size(min=5, max = 22)
	private String username;
	private Date createdAt = new Date();
	private Date lastOnline = new Date();
	private String bio;
	@NotNull
	private boolean isCreator;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_posts")
	private List<Post> posts;

	@OneToMany
	@JoinTable(name = "user_friends")
	private List<User> friends;
	@OneToMany
	private List<User> followers;
	@OneToMany
	private List<User> following;
	@OneToMany
	private List<User> subscribers;
	
	@OneToMany
	private List<HashTag> favoriteHashtags;
}

