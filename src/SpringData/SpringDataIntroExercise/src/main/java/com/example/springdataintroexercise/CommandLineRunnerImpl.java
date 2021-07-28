package com.example.springdataintroexercise;

import com.example.springdataintroexercise.entity.Book;
import com.example.springdataintroexercise.repositoty.BookRepository;
import com.example.springdataintroexercise.services.Interfaces.AuthorService;
import com.example.springdataintroexercise.services.Interfaces.BookService;
import com.example.springdataintroexercise.services.Interfaces.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookRepository bookRepository, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
//        TODO Uncheck different methods
//        printAllBooksAfter2000(2000);
//        printAllAuthorsNamesWhitBooksWhitReleaseDateBeforeYear(1990);
//        printAllAuthorsOrderedByNumberOfTheirBooks();
        printAllBooksByAuthorNameOrderByReleseDate("George", "Powell");
    }

    private void printAllBooksByAuthorNameOrderByReleseDate(String firstName, String lastName) {
        bookService
                .findAllBooksAuthorsFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsOrderedByNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWhitBooksWhitReleaseDateBeforeYear(int year) {
        bookService.findAllAuthorsWhitBooksWhitReleseDateBeforYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfter2000(int year) {
        bookService.findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBook();
    }


}
