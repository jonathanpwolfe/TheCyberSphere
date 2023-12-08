package com.thecybersphere.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
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
