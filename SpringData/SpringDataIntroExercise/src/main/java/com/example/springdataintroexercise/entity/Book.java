package com.example.springdataintroexercise.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "books")
public class Book extends BaseEntity{
    @Column(length = 50,nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.ORDINAL)
    private EditionType editionType;

    @Column
    private BigDecimal price;

    @Column
    private Integer copies;

    @Column(name = "release_date",nullable = false)
    private LocalDate releaseDate;

    @Enumerated(EnumType.ORDINAL)
    private AgeRestriction ageRestriction;

    @ManyToOne
    private Author author;

    @ManyToMany
    private Set<Category> categories;

    public Book(EditionType editionType, LocalDate releaseDate, int copies, BigDecimal price, AgeRestriction ageRestriction, String title, Author author, Set<Category> categories) {
        this.editionType =editionType;
        this.releaseDate = releaseDate;
        this.copies = copies;
        this.price = price;
        this.ageRestriction = ageRestriction;
        this.title = title;
        this.author = author;
        this.categories = categories;

    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Book() {
        this.categories = new HashSet<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EditionType getEditionType() {
        return editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }
}
