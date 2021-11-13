package com.example.musicdb.model.service;

import com.example.musicdb.model.entity.UserEntity;
import com.example.musicdb.model.entity.enums.ArtistEnum;
import com.example.musicdb.model.entity.enums.GenreEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumServiceModel {
    private Long id;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Integer copies;
    private LocalDate releaseDate;
    private String producer;
    private ArtistEnum artist;
    private GenreEnum genre;
    private String description;
    private UserEntity addedFrom;

    public AlbumServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public AlbumServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AlbumServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AlbumServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AlbumServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getCopies() {
        return copies;
    }

    public AlbumServiceModel setCopies(Integer copies) {
        this.copies = copies;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AlbumServiceModel setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public AlbumServiceModel setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public ArtistEnum getArtist() {
        return artist;
    }

    public AlbumServiceModel setArtist(ArtistEnum artist) {
        this.artist = artist;
        return this;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public AlbumServiceModel setGenre(GenreEnum genre) {
        this.genre = genre;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AlbumServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserEntity getAddedFrom() {
        return addedFrom;
    }

    public AlbumServiceModel setAddedFrom(UserEntity addedFrom) {
        this.addedFrom = addedFrom;
        return this;
    }
}
