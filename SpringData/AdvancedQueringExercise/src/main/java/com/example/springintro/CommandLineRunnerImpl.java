package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {


    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader reader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader reader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.reader = reader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        System.out.println("Select exercise you can chose from 1 to 11");
        int exNum = Integer.parseInt(reader.readLine());

        switch (exNum) {
            case 1:
                printBooksTitlesByAgeRestriction();
                break;
            case 2:
                goldenBook();
                break;
            case 3:
                booksByPrice();
                break;
            case 4:
                notReleasedBooks();
                break;
            case 5:
                booksReleasedBeforeDate();
                break;
            case 6:
                authorSearch();
                break;
            case 7:
                booksSearch();
                break;
            case 8:
                booksTitleSearch();
                break;
            case 9:
                countBooks();
                break;
            case 10:
                totalBookCopies();
                break;
            case 11:
                ReducedBook();
                break;
            default:
                System.out.println("Invalid exercise!");
                break;

        }
        System.out.println("Do you like to continue whit next exercise. Y / N");
        String input = reader.readLine().toUpperCase();
        switch (input) {
            case "Y":
                run();
                break;
            default:
                System.out.println("Good bye , and have nice day!");
                break;
        }

    }

    private void ReducedBook() throws IOException {
        System.out.println("Enter title .");
        System.out.println("For input you can chose --> Things Fall Apart !");


        String input = reader.readLine();

        System.out.println(bookService.findAllInformation(input));
    }

    private void totalBookCopies() {

        authorService.countAllCopiesByAuthor().forEach(System.out::println);

        System.out.println();
        System.out.println("Expect different output because we insert random Authors for every books.");

    }

    private void countBooks() throws IOException {
        System.out.println("Enter title length.");
        System.out.println("For input you can chose --> 12 or 40 !");

        int input = Integer.parseInt(reader.readLine());

        int count = bookService.findAllBooksTitleLength(input);

        System.out.println(count);
        System.out.printf("There are %d books with longer title than %d symbols%n",count,input);

    }

    private void booksTitleSearch() throws IOException {
        System.out.println("Expect different output because we insert random Authors for every books.");
        System.out.println("Enter the String that's Book Author last name starts with.");
        System.out.println("For input you can chose --> Ric or gr !");

        String input = reader.readLine();

        bookService.findAllBooksThatAuthorNameStartsWith(input)
                .forEach(System.out::println);
    }

    private void booksSearch() throws IOException {
        System.out.println("Enter the String that's Book title contains.");
        System.out.println("For input you can chose --> sK or WOR !");

        String input = reader.readLine();

        bookService.findAllBooksThatContainsGivenString(input)
                .forEach(System.out::println);

    }

    private void authorSearch() throws IOException {
        System.out.println("Enter the String that's first name ends with.");
        System.out.println("For input you can chose --> e or dy !");

        String input = reader.readLine();

        authorService.findAllNamesThatFirstNameEndsWith(input)
                .forEach(System.out::println);

    }

    private void booksReleasedBeforeDate() throws IOException {
        System.out.println("Enter date in format dd-MM-yyyy");
        System.out.println("For input you can chose 12-04-1992 or 30-12-1989");

        LocalDate localDate = LocalDate.parse(reader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        bookService.findAllBooksBeforeDate(localDate)
                .forEach(System.out::println);


    }

    private void notReleasedBooks() throws IOException {
        System.out.println("Enter year: ");
        System.out.println("For input you can chose 2000 or 1998");
        int year = Integer.parseInt(reader.readLine());
        bookService.findAllBooksTitlesThatNotReleasedInTheYear(year)
                .forEach(System.out::println);
    }

    private void booksByPrice() {
        bookService.findAllBookTitlesWithPriceLessThen5orMoreThen40()
                .forEach(System.out::println);
    }

    private void goldenBook() {
        bookService.findAllBookTitleWithCopiesLessThen5000()
                .forEach(System.out::println);

    }

    private void printBooksTitlesByAgeRestriction() throws IOException {
        System.out.println("For input you can chose --> miNor or teEN");
        String input = reader.readLine().toUpperCase();
        AgeRestriction ageRestriction = AgeRestriction.valueOf(input);
        bookService.findAllByAgeRestriction(ageRestriction)
                .forEach(book -> System.out.println(book.getTitle()));
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
