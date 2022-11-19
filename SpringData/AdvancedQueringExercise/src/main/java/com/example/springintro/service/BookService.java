package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);


    List<String> findAllBookTitleWithCopiesLessThen5000();

    List<String> findAllBookTitlesWithPriceLessThen5orMoreThen40();

    List<String> findAllBooksTitlesThatNotReleasedInTheYear(int year);

    List<String> findAllBooksBeforeDate(LocalDate localDate);

    List<String> findAllBooksThatContainsGivenString(String input);

    List<String> findAllBooksThatAuthorNameStartsWith(String input);

    int findAllBooksTitleLength(int input);


    String findAllInformation(String input);
}
