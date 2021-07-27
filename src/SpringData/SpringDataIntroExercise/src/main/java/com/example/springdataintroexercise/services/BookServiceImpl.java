package com.example.springdataintroexercise.services;

import com.example.springdataintroexercise.entity.*;
import com.example.springdataintroexercise.repositoty.BookRepository;
import com.example.springdataintroexercise.services.Interfaces.AuthorService;
import com.example.springdataintroexercise.services.Interfaces.BookService;
import com.example.springdataintroexercise.services.Interfaces.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOK_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBook() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }
//        TODO Add file path of your file
        Files.readAllLines(Path.of("D:\\SoftUniGit\\src\\SpringData\\SpringDataIntroExercise\\src\\main\\resources\\files\\books.txt"))
                .stream()
                .forEach(row -> {
                    String[] data = row.split("\\s+");

                    Book book = createBookFromData(data);
                    bookRepository.save(book);
                });

    }

    @Override
    public List<Book> findAllBooksAfterYear(int yar) {

        return bookRepository.findAllByReleaseDateAfter(LocalDate.of(yar, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWhitBooksWhitReleseDateBeforYear(int year) {
        return bookRepository.findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksAuthorsFirstAndLastNameOrderByReleaseDate(String fName,String lName) {
       return   bookRepository.findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(fName,lName)
        .stream().map(book -> String.format("%s %s %d"
        ,book.getTitle(),
                book.getReleaseDate(),
                book.getCopies())).collect(Collectors.toList());
    }

    private Book createBookFromData(String[] data) {
        EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
        LocalDate releaseDate = LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        int copies = Integer.parseInt(data[2]);
        BigDecimal price = new BigDecimal(data[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(data[4])];
        String title = Arrays.stream(data)
                .skip(5).collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();

        Book book = new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);
        return book;
    }
}
