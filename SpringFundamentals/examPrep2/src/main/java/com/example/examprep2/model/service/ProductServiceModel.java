package com.example.examprep2.model.service;

import com.example.examprep2.model.enums.CategoryEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductServiceModel {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime neededBefore;
//    Задължително енъм за да се намапи;
    private CategoryEnum category;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public void setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
