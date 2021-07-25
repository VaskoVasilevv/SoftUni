package com.example.springdataintroexercise.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity{

    @OneToMany(mappedBy = "author",fetch = FetchType.EAGER)
    private Set<Book> books;

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    public Author() {
    }

    public Author(String fName,String lName) {
        this.firstName = fName;
        this.lastName = lName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
