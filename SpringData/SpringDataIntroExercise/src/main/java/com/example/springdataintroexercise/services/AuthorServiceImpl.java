package com.example.springdataintroexercise.services;

import com.example.springdataintroexercise.entity.Author;
import com.example.springdataintroexercise.repositoty.AuthorsRepository;
import com.example.springdataintroexercise.services.Interfaces.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    public static final String AUTHORS_FILE_PATH = "src/main/resources/files/authors.txt";

    private final AuthorsRepository authorsRepository;

    public AuthorServiceImpl(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }


    @Override
    public void seedAuthors() throws IOException {
        if (authorsRepository.count() > 0) {
            return;
        }
        //TODO Add authors path
        Files.readAllLines(Path.of("D:\\SoftUniGit\\src\\SpringData\\SpringDataIntroExercise\\src\\main\\resources\\files\\authors.txt"))
                .stream().forEach(row -> {
            String[] split = row.split("\\s+");
            Author author = new Author(split[0], split[1]);

            authorsRepository.save(author);

        });


    }

    @Override
    public Author getRandomAuthor() {
        long randomId = ThreadLocalRandom
                .current().nextLong(1, authorsRepository.count() + 1);

        return authorsRepository.findById(randomId).orElse(null);
    }

    @Override
    public List<String> getAllAuthorsOrderByCountOfTheirBooks() {

        return authorsRepository.findAllByBooksSizeDESC()
                .stream()
                .map(author -> String.format("%s %s %d"
                        , author.getFirstName(),
                        author.getLastName(),
                        author.getBooks().size())).collect(Collectors.toList());
    }
}
