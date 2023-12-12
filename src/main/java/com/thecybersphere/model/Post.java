 package com.thecybersphere.model;

import java.util.List;
import java.util.UUID;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_posts")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String title;
    private String about;

    @OneToMany(mappedBy = "post") // Use mappedBy to specify the inverse side of the relationship
    private List<Media> media;

    @OneToMany(mappedBy = "post") // Use mappedBy to specify the inverse side of the relationship
    private List<Comment> comments;
}
