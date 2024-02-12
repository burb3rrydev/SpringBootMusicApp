package com.gcu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

@Entity
public class MusicProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String artist;
    @Column(name = "audio_url")
    private String audioUrl;

    @Column(name = "picture_url")
    private String pictureUrl;

    // Constructors (you may generate these based on your needs)

    // Default constructor
    public MusicProduct() {
    }

    // Parameterized constructor
    public MusicProduct(String name, String artist, String audioFilePath, String pictureFilePath) {
        this.name = name;
        this.artist = artist;
        this.audioUrl = audioFilePath;
        this.pictureUrl = pictureFilePath;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    // Additional methods or overrides if needed

    @Override
    public String toString() {
        return "MusicProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", audioFilePath='" + audioUrl + '\'' +
                ", pictureFilePath='" + pictureUrl + '\'' +
                '}';
    }
}
