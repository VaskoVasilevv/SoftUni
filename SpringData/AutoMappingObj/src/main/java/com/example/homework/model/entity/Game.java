package com.example.homework.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "games")
public class Game extends BaseEntity{

    @Column
    private String title;
    @Column
    private String trailer;
    @Column(name = "image_thumbnail")
    private String imageThumbnail;
    @Column
    private Double size;
    @Column
    private BigDecimal price;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "release_date")
    private LocalDate releaseDate;

    public Game() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {

        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return String.format("Title: %a%nPrice: %.2f%nDescription: %s%nRelease date: %s"
        ,getTitle(),getPrice(),getDescription(),getReleaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}
