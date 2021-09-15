package com.example.springdataintroexercise.services;

import com.example.springdataintroexercise.entity.Category;
import com.example.springdataintroexercise.repositoty.CategoryRepository;
import com.example.springdataintroexercise.services.Interfaces.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_FILE_PATH = "src/main/resources/files/categories.txt";

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
       if (categoryRepository.count() > 0){
           return;
       }

       //TODO add Categories File Path
        Files.readAllLines(Path.of("D:\\SoftUniGit\\src\\SpringData\\SpringDataIntroExercise\\src\\main\\resources\\files\\categories.txt")).stream()

               .filter(r -> !r.isEmpty())
               .forEach(categoryName -> {
                   Category category = new Category(categoryName);

                   categoryRepository.save(category);
               });
    }

    @Override
    public Set<Category> getRandomCategories() {

        Set<Category> categories = new HashSet<>();
        int randInt = ThreadLocalRandom
                .current().nextInt(1,3);

        for (int i = 0; i < randInt; i++) {
            long randId = ThreadLocalRandom
                    .current().nextLong(1,categoryRepository.count() + 1);
            Category category = categoryRepository
                    .findById(randId).orElse(null);

             categories.add(category);
        }
        return categories;
    }
}
