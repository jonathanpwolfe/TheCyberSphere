package com.thecybersphere.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

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
public class CyberSphereUser extends User{


	public CyberSphereUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}

	public CyberSphereUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}

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
	private List<CyberSphereUser> friends;
	@OneToMany
	private List<CyberSphereUser> followers;
	@OneToMany
	private List<CyberSphereUser> following;
	@OneToMany
	private List<CyberSphereUser> subscribers;
	
	@OneToMany
	private List<HashTag> favoriteHashtags;
}

