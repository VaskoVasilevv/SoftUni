package com.example.homework.model.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class AddGameDto {

    @Pattern(regexp = "[A-Za-z]{6,100}$",message = "Invalid input for AddGameDto title")
    private String title;
    @DecimalMin(value = "0",message = "Invalid input for AddGameDto price")
    private BigDecimal price;
    @Positive(message = "Invalid input for AddGameDto size")
    private Double size;
    @Size(min = 11,max = 11,message = "Invalid input for AddGameDto trailer")
    private String trailer;
    @Pattern(regexp = "(https?).+",message = "Invalid input for AddGameDto URL")
    private String thumbnailURL;
    @Size(min = 20,message = "Invalid input for AddGameDto description")
    private String description;

    private String releaseDate;

    public AddGameDto() {
    }

    public AddGameDto(String title, BigDecimal price, Double size, String trailer, String thumbnailURL, String description,String releaseDate) {
        this.title = title;
        this.price = price;
        this.size = size;
        this.trailer = trailer;
        this.thumbnailURL = thumbnailURL;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
