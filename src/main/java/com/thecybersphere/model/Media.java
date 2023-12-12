package com.thecybersphere.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_media")
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force = true)
public class Media {

    public enum EncodingType {
        UNKNOWN,
        MP3,
        MP4,
        // Add more encoding types as needed
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private EncodingType encodingType = EncodingType.UNKNOWN; // Assign a default value
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<HashTag> hashtags;
    
    @ManyToOne
    @JoinColumn(name = "post_id") // This should match the name of the column in the "comments" table
    private Post post;
    // Constructors
    public Media() {
        // Default constructor
    }

    public Media(EncodingType encodingType) {
        this.encodingType = encodingType;
    }

    // Getters and setters
    public EncodingType getEncodingType() {
        return encodingType;
    }

    public void setEncodingType(EncodingType encodingType) {
        this.encodingType = encodingType;
    }

    // Other methods as needed
}
