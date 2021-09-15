package com.example.springdataintroexercise.services.Interfaces;

import com.example.springdataintroexercise.entity.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBook() throws IOException;
    List<Book> findAllBooksAfterYear(int yar);

    List<String> findAllAuthorsWhitBooksWhitReleseDateBeforYear(int year);

    List<String> findAllBooksAuthorsFirstAndLastNameOrderByReleaseDate(String firstName,String lastNAme );

}
